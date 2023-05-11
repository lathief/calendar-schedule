package com.lathief.calendar.service.impl;

import com.lathief.calendar.entity.Engagement;
import com.lathief.calendar.entity.Schedule;
import com.lathief.calendar.entity.User;
import com.lathief.calendar.enums.RequestStatus;
import com.lathief.calendar.exception.CalendarException;
import com.lathief.calendar.exception.ErrorCode;
import com.lathief.calendar.payload.request.EventRequest;
import com.lathief.calendar.repository.EngagementRepository;
import com.lathief.calendar.repository.ScheduleRepository;
import com.lathief.calendar.service.EmailService;
import com.lathief.calendar.service.EngagementService;
import com.lathief.calendar.service.ScheduleService;
import com.lathief.calendar.service.UserService;
import com.lathief.calendar.utils.EngagementEmailStuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    EngagementRepository engagementRepository;
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    public Schedule getOne(Long id) {
        return scheduleRepository.findById(id).get();
    }

    public List<Schedule> getAll() {
        return null;
    }

    public void create(EventRequest eventRequest) {
        Schedule eventSchedule = new Schedule();
        try {
            eventSchedule.setTitle(eventRequest.getTitle());
            eventSchedule.setDescription(eventRequest.getDescription());
            eventSchedule.setStartAt(eventRequest.getStartAt());
            eventSchedule.setEndAt(eventRequest.getEndAt());
//            eventSchedule.setUser();
            eventSchedule.setScheduleType(eventRequest.getScheduleType());
            List<Engagement> engagementList = engagementRepository.findAllByUserIdInAndSchedule_EndAtAfter(
                    eventRequest.getAttendeeIds(), eventRequest.getStartAt());
            if (engagementList.stream()
                    .anyMatch(e -> e.getEvent().isOverlapped(eventRequest.getStartAt(), eventRequest.getEndAt()) &&
                            e.getRequestStatus() == RequestStatus.ACCEPTED)) {
                throw new CalendarException(ErrorCode.EVENT_CREATE_OVERLAPPED_PERIOD);
            }
            scheduleRepository.save(eventSchedule);
            List<User> attendeeList = eventRequest.getAttendeeIds().stream().map(userService::getOrThrowById).toList();
            attendeeList.forEach(user -> {
                Engagement e = engagementRepository.save(new Engagement(user, eventSchedule));
                emailService.sendEngagement(new EngagementEmailStuff(
                        e.getSchedule().getTitle(),
                        e.getSchedule().getDescription(),
                        e.getUser().getEmail(),
                        e.getSchedule().getId(),
                        e.getId()
                ));
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to create schedule event");
        }
    }

    public void update(Long id, EventRequest eventRequest) {

    }

    public void delete(Long id) {

    }
}

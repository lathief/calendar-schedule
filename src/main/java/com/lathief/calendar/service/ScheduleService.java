package com.lathief.calendar.service;

import com.lathief.calendar.entity.Schedule;
import com.lathief.calendar.payload.request.EventRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<Schedule> getAll();
    Schedule getOne(Long id);
    void create(EventRequest eventRequest);
    void update(Long id, EventRequest eventRequest);
    void delete(Long id);
}

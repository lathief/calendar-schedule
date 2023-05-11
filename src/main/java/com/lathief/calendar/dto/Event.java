package com.lathief.calendar.dto;

import com.lathief.calendar.entity.Schedule;
import com.lathief.calendar.entity.User;
import com.lathief.calendar.utils.Period;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Event {
    private Schedule schedule;
    protected Event() {}
    public Event(Schedule schedule) {
        this.schedule = schedule;
    }
    public Long getId() {
        return this.schedule.toEvent().getId();
    }
    public LocalDateTime getStartAt() {
        return schedule.getStartAt();
    }
    public LocalDateTime getEndAt() {
        return schedule.getEndAt();
    }
    public User getWriter() {
        return this.schedule.getUser();
    }
    public String getTitle() {
        return this.schedule.getTitle();
    }
    public Period getPeriod() {
        return Period.of(this.schedule.getStartAt(), this.schedule.getEndAt());
    }
    public boolean isOverlapped(LocalDateTime startAt, LocalDateTime endAt) {
        return this.getStartAt().isBefore(endAt) && startAt.isBefore(this.getEndAt());
    }
}

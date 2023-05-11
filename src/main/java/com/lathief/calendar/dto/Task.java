package com.lathief.calendar.dto;

import com.lathief.calendar.entity.Schedule;

public class Task {
    private Schedule schedule;

    public String getTitle() {
        return schedule.getTitle();
    }
    public String getDescription() {
        return schedule.getDescription();
    }
    protected Task() {}

    public Task(Schedule schedule) {
        this.schedule = schedule;
    }
}

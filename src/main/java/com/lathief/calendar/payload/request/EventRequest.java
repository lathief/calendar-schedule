package com.lathief.calendar.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lathief.calendar.enums.ScheduleType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class EventRequest {
    private String title;
    private String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startAt;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endAt;
    private List<Long> attendeeIds;
    private ScheduleType scheduleType;
}

package com.lathief.calendar.entity;

import com.lathief.calendar.dto.Event;
import com.lathief.calendar.dto.Task;
import com.lathief.calendar.entity.base.BaseEntity;
import com.lathief.calendar.enums.ScheduleType;
import com.lathief.calendar.utils.Period;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task toTask() {
        return new Task(this);
    }
    public Event toEvent() {
        return new Event(this);
    }
    public boolean isOverlapped(LocalDate date) {
        return Period.of(this.getStartAt(), this.getEndAt()).isOverlapped(date);
    }

    public boolean isOverlapped(Period period) {
        return Period.of(this.getStartAt(), this.getEndAt()).isOverlapped(period);
    }
}

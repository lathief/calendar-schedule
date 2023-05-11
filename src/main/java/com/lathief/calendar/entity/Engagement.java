package com.lathief.calendar.entity;

import com.lathief.calendar.dto.Event;
import com.lathief.calendar.entity.base.BaseEntity;
import com.lathief.calendar.enums.RequestReplyType;
import com.lathief.calendar.enums.RequestStatus;
import com.lathief.calendar.utils.Period;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "engagement")
@NoArgsConstructor
@AllArgsConstructor
public class Engagement extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    public Engagement(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }

    public Event getEvent() {
        return schedule.toEvent();
    }
    public boolean isOverlapped(LocalDate date) {
        return this.schedule.isOverlapped(date);
    }

    public boolean isOverlapped(Period period) {
        return this.schedule.isOverlapped(period);
    }

    public Engagement reply(RequestReplyType type) {
        switch (type) {
            case ACCEPT -> this.requestStatus = RequestStatus.ACCEPTED;
            case REJECT -> this.requestStatus = RequestStatus.REJECTED;
        }
        return this;
    }
}

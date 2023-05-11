package com.lathief.calendar.repository;

import com.lathief.calendar.entity.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EngagementRepository extends JpaRepository<Engagement, Long> {
    List<Engagement> findAllByUserIdInAndSchedule_EndAtAfter(List<Long> attendeeIds, LocalDateTime startAt);
    List<Engagement> findAllByUserId(Long id);
}

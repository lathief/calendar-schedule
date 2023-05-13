package com.lathief.calendar.service;

import com.lathief.calendar.entity.Engagement;
import org.springframework.stereotype.Service;

@Service
public interface EngagementService {
    Engagement getEngagement(Long id);
    void updateEngagement();
}

package com.lathief.calendar.service;

import com.lathief.calendar.entity.Engagement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public interface EngagementService {
    Engagement getEngagement(Long id);
    void updateEngagement();
}

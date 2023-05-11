package com.lathief.calendar.service;

import com.lathief.calendar.utils.EngagementEmailStuff;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEngagement(EngagementEmailStuff stuff);
}

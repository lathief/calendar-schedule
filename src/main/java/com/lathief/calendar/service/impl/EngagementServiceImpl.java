package com.lathief.calendar.service.impl;

import com.lathief.calendar.entity.Engagement;
import com.lathief.calendar.repository.EngagementRepository;
import com.lathief.calendar.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EngagementServiceImpl implements EngagementService {
    @Autowired
    EngagementRepository engagementRepository;
    public Engagement getEngagement(Long id) {
        return engagementRepository.findById(id).get();
    }
    public void updateEngagement() {

    }
}

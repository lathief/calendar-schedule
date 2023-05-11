package com.lathief.calendar.controller;

import com.lathief.calendar.entity.Engagement;
import com.lathief.calendar.enums.RequestReplyType;
import com.lathief.calendar.payload.request.EventRequest;
import com.lathief.calendar.repository.EngagementRepository;
import com.lathief.calendar.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class EngagementController {
    @Autowired
    EngagementService engagementService;
    @GetMapping("/{id}/engagement")
    public ResponseEntity<?> getEngagement (@PathVariable Long id) {
        Engagement getEngagement = engagementService.getEngagement(id);
        return null;
    }
    @PutMapping("/{id}/engagement/{engagementId}")
    public ResponseEntity<?> updateEngagement (@PathVariable("id") Long id,
                                               @PathVariable("engagementId") String engagementId,
                                               @RequestParam RequestReplyType type) {
        engagementService.updateEngagement();
        return null;
    }
}

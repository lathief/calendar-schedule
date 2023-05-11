package com.lathief.calendar.controller;

import com.lathief.calendar.entity.Schedule;
import com.lathief.calendar.payload.request.EventRequest;
import com.lathief.calendar.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    EngagementController engagementController;
    @GetMapping("/all")
    public ResponseEntity<?> getSchedules (
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String today,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String when,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startWeek,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM") String month
    ) {
        List<Schedule> getSchedules = scheduleService.getAll();
        return ResponseEntity.ok(getSchedules);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSchedule (@PathVariable Long id) {
        Schedule getSchedule = scheduleService.getOne(id);
        return ResponseEntity.ok(getSchedule);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createSchedule (@RequestBody EventRequest eventRequest) {
        scheduleService.create(eventRequest);
        return new ResponseEntity<>("Schedule created successfully", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSchedule (
            @PathVariable Long id,
            @RequestBody EventRequest eventRequest) {
        scheduleService.update(id, eventRequest);
        return ResponseEntity.ok("Schedule updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSchedule (@PathVariable Long id) {
        scheduleService.delete(id);
        return ResponseEntity.ok("Schedule updated successfully");
    }



}


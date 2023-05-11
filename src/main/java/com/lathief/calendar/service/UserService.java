package com.lathief.calendar.service;

import com.lathief.calendar.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getOrThrowById(Long id);
}

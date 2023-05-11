package com.lathief.calendar.service.impl;

import com.lathief.calendar.entity.User;
import com.lathief.calendar.repository.UserRepository;
import com.lathief.calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    public User getOrThrowById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("no user."));
    }
}

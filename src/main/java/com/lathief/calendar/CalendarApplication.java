package com.lathief.calendar;

import com.lathief.calendar.entity.User;
import com.lathief.calendar.enums.Gender;
import com.lathief.calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CalendarApplication implements ApplicationRunner {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		List<User> users = new ArrayList<>();
		users.add(new User("John", "janjisetia24@yahoo.com", "password123", LocalDate.now(), Gender.MALE));
		users.add(new User("Doe", "shadowmaster241099@yahoo.co.id", "password456", LocalDate.now(), Gender.FEMALE));

		for (User a : users) {
			if (userRepository.findOneByUsername(a.getUsername()) == null) {
				userRepository.save(a);
			}
		}
	}
}

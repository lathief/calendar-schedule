package com.lathief.calendar.repository;

import com.lathief.calendar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    User findOneByEmail(String email);
    @Query("FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findOneByUsername(String username);
}

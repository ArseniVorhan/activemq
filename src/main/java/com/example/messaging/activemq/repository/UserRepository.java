package com.example.messaging.activemq.repository;

import com.example.messaging.activemq.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
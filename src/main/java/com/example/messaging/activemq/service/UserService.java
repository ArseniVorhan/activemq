package com.example.messaging.activemq.service;

import com.example.messaging.activemq.domain.User;
import com.example.messaging.activemq.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @Autowired
    UserRepository userRepository;

    public User sendToActiveMQifSucceed(String name) {
        val user = createUser(name);
        throwExceptionMethod(name);
        jmsTemplate.convertAndSend(queue, "Success");
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User createUser(String name) {
        val user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    private void throwExceptionMethod(String name) {
        if (name.startsWith("A")) {
            throw new RuntimeException();
        }
    }
}

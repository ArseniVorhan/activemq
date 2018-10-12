package com.example.messaging.activemq.listener;

import com.example.messaging.activemq.domain.User;
import com.example.messaging.activemq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CreateUserConsumer {

    @Autowired
    UserService userService;

    @JmsListener(destination = "standalone.queue")
    public void consume(String message) {

        System.out.println(message);
        System.out.println(userService.getAllUsers());
    }
}

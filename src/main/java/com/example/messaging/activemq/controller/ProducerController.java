package com.example.messaging.activemq.controller;

import com.example.messaging.activemq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/create")
public class ProducerController {

    @Autowired
    UserService userService;

    @GetMapping("/{userName}")
    public String publish(@PathVariable final String userName) {

        userService.sendToActiveMQifSucceed(userName);
        return "Sent to queue";
    }
}

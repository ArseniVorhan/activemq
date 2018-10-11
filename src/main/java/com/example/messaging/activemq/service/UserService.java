package com.example.messaging.activemq.service;

import com.example.messaging.activemq.domain.User;
import com.example.messaging.activemq.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createAndUpdateUser(String name) throws Exception {
        val user = createUser(name);
        throwExceptionMethod();
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

    private void throwExceptionMethod() throws Exception {
        throw new Exception();
    }
}

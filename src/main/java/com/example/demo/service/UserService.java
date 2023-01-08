package com.example.demo.service;

import com.example.demo.api.persistence.UserEntity;
import com.example.demo.api.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUser(Integer id) {
        return userRepository.getUserEntityById(id);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        userRepository.save(user);
        return user;
    }
}

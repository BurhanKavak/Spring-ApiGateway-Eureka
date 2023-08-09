package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserService {

    List<User> users();

    User getUserById(Long userId);
    User createUser(User user);
}

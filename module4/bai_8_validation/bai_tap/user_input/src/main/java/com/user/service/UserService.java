package com.user.service;

import com.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);
}

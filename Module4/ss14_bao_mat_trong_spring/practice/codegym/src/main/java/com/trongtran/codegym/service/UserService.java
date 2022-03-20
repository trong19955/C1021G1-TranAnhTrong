package com.trongtran.codegym.service;

import com.trongtran.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    //    void save(User user);
//    void update(User user);
    User findById(int id);
}

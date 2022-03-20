package com.trongtran.codegym.service.impl;

import com.trongtran.codegym.model.User;
import com.trongtran.codegym.repository.UserRepository;
import com.trongtran.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return null;
    }
}

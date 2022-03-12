package com.codegym.validation.service.impl;


import com.codegym.validation.repository.IUserRepository;
import com.codegym.validation.service.IUserService;

import com.codegym.validation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);

    }
}

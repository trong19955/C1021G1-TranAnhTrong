package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.MyUserDetail;
import com.trongtran.demo.model.User;
import com.trongtran.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) repository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User name " + username + " not found");
        }

        return new MyUserDetail(user);
    }
}

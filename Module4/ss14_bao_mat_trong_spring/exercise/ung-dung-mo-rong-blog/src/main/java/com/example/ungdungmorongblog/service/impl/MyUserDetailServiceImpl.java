package com.example.ungdungmorongblog.service.impl;
import com.example.ungdungmorongblog.model.MyUserDetail;
import com.example.ungdungmorongblog.repository.IUserRepository;
import com.example.ungdungmorongblog.model.User;
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

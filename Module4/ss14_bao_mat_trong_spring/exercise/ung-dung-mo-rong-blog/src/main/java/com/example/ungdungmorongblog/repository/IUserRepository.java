package com.example.ungdungmorongblog.repository;


import com.example.ungdungmorongblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}

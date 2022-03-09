package com.example.demo.service;


import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void remove(int id);
}

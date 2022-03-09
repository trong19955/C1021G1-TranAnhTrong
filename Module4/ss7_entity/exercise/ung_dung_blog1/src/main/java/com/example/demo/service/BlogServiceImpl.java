package com.example.demo.service;


import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }



}

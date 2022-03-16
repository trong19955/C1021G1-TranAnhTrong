package com.trongtran.demo.service;

import com.trongtran.demo.model.Blog;
import com.trongtran.demo.repository.IBogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBogRepository repository;

    @Override
    public Iterable<Blog> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(Integer categoryID) {
        return this.repository.findAllByCategoryId(categoryID);
    }
}

package com.example.ungdungmorongblog.service.impl;

import com.example.ungdungmorongblog.model.Blog;
import com.example.ungdungmorongblog.repository.IBlogRepository;
import com.example.ungdungmorongblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

//    @Override
//    public List<Blog> finAll() {
//
//        return repository.findAll();
//
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Blog> searchByName(String name) {
         return repository.searchByName(name);

    }
}

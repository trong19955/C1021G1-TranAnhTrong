package com.trongtran.demo.service;

import com.trongtran.demo.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    Iterable<Blog> findAllByCategoryId(Integer categoryID);
}

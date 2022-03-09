package com.example.ungdungmorongblog.service;

import com.example.ungdungmorongblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    List<Blog> searchByName(String name);

}

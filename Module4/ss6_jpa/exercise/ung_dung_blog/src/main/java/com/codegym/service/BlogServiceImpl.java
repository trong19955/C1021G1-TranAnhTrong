package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService<Blog> {


    @Qualifier("blogRepositoryImpl")
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        if (blogRepository.findById(id) != null){
            return (Blog) blogRepository.findById(id);
        }else {
            return null;
        }

    }

    @Override
    public void save(Blog blog) { blogRepository.save(blog);

    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}



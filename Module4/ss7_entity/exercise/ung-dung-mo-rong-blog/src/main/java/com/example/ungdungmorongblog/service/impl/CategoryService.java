package com.example.ungdungmorongblog.service.impl;

import com.example.ungdungmorongblog.model.Category;
import com.example.ungdungmorongblog.repository.ICategoryRepository;
import com.example.ungdungmorongblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}

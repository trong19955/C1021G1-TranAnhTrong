package com.example.ungdungmorongblog.service;

import com.example.ungdungmorongblog.model.Category;

import java.util.Calendar;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void save(Category category);
    void remove(Integer id);
}

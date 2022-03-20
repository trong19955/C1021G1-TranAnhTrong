package com.example.ungdungmorongblog.repository;

import com.example.ungdungmorongblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}

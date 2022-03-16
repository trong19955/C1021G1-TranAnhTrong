package com.trongtran.demo.repository;

import com.trongtran.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findAllByCategoryId(Integer categoryId);
}

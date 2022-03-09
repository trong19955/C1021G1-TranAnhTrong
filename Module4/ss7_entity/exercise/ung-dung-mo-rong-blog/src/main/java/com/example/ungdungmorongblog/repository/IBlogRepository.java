package com.example.ungdungmorongblog.repository;

import com.example.ungdungmorongblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    List<Blog> findByNameBlogContaining(String name);
}

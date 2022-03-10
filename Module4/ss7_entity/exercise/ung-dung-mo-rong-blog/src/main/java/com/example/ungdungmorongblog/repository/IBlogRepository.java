package com.example.ungdungmorongblog.repository;

import com.example.ungdungmorongblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    @Query(value = "select*from blog_extend.blog LEFT JOIN blog_extend.category ON blog.id=category.id where name_blog =:keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String keyword);
}

package com.trongtran.repository;

import com.trongtran.model.Passbook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPassbookRepository extends PagingAndSortingRepository<Passbook, Integer > {

//    @Query(value = "select*from blog_extend.blog LEFT JOIN blog_extend.category ON blog.id=category.id where name_blog =:keyword", nativeQuery = true)
    List<Passbook> searchByName(@Param("keyword") String keyword);

}

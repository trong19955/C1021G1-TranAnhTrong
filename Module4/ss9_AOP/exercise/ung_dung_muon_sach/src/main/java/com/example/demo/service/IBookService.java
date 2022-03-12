package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Book findById(Integer id);

    void remove(Integer id);

    List<Book> searchByName(String name);
}

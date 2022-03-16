package com.example.demo.service.impl;
import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository repository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }else {
            return null;
        }

    }

}

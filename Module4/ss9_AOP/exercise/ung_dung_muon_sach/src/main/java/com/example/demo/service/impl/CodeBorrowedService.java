package com.example.demo.service.impl;

import com.example.demo.model.CodeBorrowed;
import com.example.demo.repository.ICodeBorrowedRepository;
import com.example.demo.service.ICodeBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBorrowedService implements ICodeBorrowedService {

    @Autowired
    private ICodeBorrowedRepository repository;

    @Override
    public CodeBorrowed findByCode(String code) {
        return repository.findByCodeBorrow(code);

    }

    @Override
    public void save(CodeBorrowed codeBorrowed) {
        repository.save(codeBorrowed);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}


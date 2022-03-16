package com.example.demo.service;


import com.example.demo.model.CodeBorrowed;

public interface ICodeBorrowedService {
    CodeBorrowed findByCode(String code);

    void save(CodeBorrowed codeBorrowed);

    void remove(int id);
}


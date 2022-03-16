package com.example.demo.repository;


import com.example.demo.model.CodeBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeBorrowedRepository extends JpaRepository<CodeBorrowed, Integer> {
    CodeBorrowed findByCodeBorrow(String code);
}

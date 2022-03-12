package com.example.demo.repository;

import com.example.demo.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeRepository extends JpaRepository<Code, Integer> {
}

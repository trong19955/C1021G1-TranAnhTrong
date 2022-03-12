package com.example.demo.service;

import com.example.demo.model.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();
    Code findById(Integer id);
    void save(Code code);
    void remove( Integer id);
}

package com.example.demo.service.impl;

import com.example.demo.model.Code;
import com.example.demo.repository.ICodeRepository;
import com.example.demo.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeService implements ICodeService {
    @Autowired
    private ICodeRepository repository;
    @Override
    public List<Code> findAll() {
        return repository.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        repository.save(code);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}

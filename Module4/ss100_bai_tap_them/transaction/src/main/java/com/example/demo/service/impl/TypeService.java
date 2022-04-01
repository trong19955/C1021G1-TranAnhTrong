package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ITypeRepository;
import com.example.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository repository;

    @Override
    public List<Product> findAll() {
       return repository.findAll();
    }
}

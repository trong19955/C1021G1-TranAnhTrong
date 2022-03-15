package com.trongtran.codegym.service;

import com.trongtran.codegym.model.Product;


import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
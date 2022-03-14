package com.trongtran.codegym.service;

import com.trongtran.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}

package com.trongtran.demo.service;

import com.trongtran.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {
    Page<Service> findAll(Pageable pageable);
}

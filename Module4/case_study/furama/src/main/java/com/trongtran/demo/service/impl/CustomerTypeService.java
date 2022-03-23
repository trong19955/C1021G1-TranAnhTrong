package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.Customer;
import com.trongtran.demo.model.CustomerType;
import com.trongtran.demo.repository.ICustomerTypeRepository;
import com.trongtran.demo.service.ICustomerService;
import com.trongtran.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository repository;


    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}

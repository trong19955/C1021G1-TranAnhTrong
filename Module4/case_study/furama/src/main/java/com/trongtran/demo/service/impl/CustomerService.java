package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.Customer;
import com.trongtran.demo.repository.ICustomerRepository;
import com.trongtran.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }


}

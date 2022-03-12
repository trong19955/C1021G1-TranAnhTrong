package com.trongtran.service.impl;

import com.trongtran.model.Customer;
import com.trongtran.repository.ICustomerRepository;
import com.trongtran.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
   @Autowired
   private ICustomerRepository repository;
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}

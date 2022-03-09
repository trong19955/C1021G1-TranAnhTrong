package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);

    }

    @Override
    public Page<Customer> finAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        return iCustomerRepository.findAllByNameContaining(name,pageable);
    }
}

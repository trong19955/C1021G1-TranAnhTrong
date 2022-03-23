package com.trongtran.demo.service;

import com.trongtran.demo.model.Customer;
import com.trongtran.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void remove(Integer id);

    Customer findById(Integer id);
}

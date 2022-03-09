package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository  extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);


}

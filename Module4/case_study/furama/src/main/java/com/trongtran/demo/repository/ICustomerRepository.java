package com.trongtran.demo.repository;

import com.trongtran.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

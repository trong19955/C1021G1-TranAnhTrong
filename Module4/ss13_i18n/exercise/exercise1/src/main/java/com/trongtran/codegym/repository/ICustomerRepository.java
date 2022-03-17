package com.trongtran.codegym.repository;

import com.trongtran.codegym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

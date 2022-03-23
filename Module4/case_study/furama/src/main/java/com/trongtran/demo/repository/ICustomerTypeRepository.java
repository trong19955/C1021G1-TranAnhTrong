package com.trongtran.demo.repository;

import com.trongtran.demo.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}

package com.trongtran.repository;

import com.trongtran.model.Customer;
import com.trongtran.model.Passbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

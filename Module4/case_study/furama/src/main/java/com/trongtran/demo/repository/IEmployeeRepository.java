package com.trongtran.demo.repository;

import com.trongtran.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByEmployeeNameContaining(String customerName, Pageable pageable);

}

package com.trongtran.demo.service;

import com.trongtran.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void remove(Integer id);

    Employee findById(Integer id);

    Page<Employee> findByEmployee_EmployeeName(String employeeName, Pageable pageable);

}

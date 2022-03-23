package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.Employee;
import com.trongtran.demo.repository.IEmployeeRepository;
import com.trongtran.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
@Autowired
    private IEmployeeRepository repository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findByEmployee_EmployeeName(String employeeName, Pageable pageable) {
        return repository.findByEmployeeNameContaining(employeeName,pageable);
    }


}

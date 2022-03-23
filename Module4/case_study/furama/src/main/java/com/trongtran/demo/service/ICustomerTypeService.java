package com.trongtran.demo.service;

import com.trongtran.demo.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}

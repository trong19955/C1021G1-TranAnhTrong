package com.trongtran.demo.service.impl;

import com.trongtran.demo.repository.IServiceRepository;
import com.trongtran.demo.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
     private  IServiceRepository iServiceRepository;
    @Override
    public List<com.trongtran.demo.model.Service> findAll() {
        return iServiceRepository.findAll();
    }
}

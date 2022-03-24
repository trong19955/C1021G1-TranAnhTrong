package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.RentType;
import com.trongtran.demo.repository.IRentTypeRepository;
import com.trongtran.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}

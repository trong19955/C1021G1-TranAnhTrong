package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.Division;
import com.trongtran.demo.repository.IDivisionRepository;
import com.trongtran.demo.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }

}

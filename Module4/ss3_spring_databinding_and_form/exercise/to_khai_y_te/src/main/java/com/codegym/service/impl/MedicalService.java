package com.codegym.service.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    IMedicalRepository iMedicalRepository;

    @Override
    public List<Medical> findAll() {
        return iMedicalRepository.findAll();
    }

    @Override
    public void createNew(Medical medical) {
        iMedicalRepository.createNew(medical);
    }
}

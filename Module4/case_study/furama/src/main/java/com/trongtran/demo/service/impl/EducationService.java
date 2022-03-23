package com.trongtran.demo.service.impl;


import com.trongtran.demo.model.EducationDegree;
import com.trongtran.demo.repository.IEducationDegree;
import com.trongtran.demo.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationService implements IEducationDegreeService {
    @Autowired
    private IEducationDegree iEducationDegree;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegree.findAll();
    }
}

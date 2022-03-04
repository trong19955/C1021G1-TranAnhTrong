package com.codegym.service;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalService {
    public List<Medical> findAll();
    public void createNew(Medical medical);
}

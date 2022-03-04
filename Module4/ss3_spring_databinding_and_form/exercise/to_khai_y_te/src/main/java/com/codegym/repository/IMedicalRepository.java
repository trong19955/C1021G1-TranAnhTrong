package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalRepository {
    public List<Medical> findAll();
    public void createNew(Medical medical);
}

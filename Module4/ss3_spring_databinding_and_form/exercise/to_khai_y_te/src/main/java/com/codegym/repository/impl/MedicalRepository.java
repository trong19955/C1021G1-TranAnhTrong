package com.codegym.repository.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalRepository implements IMedicalRepository {
    private static final List<Medical> medicals = new ArrayList<>();
    static {
        medicals.add(new Medical("Trần Anh Trọng","1995","Nam","Việt Nam","239456789","Ô tô","C79-567876","4","2022-09-25",
                "2022-09-26","không có","Đà Nẵng","Liên Chiểu","Hòa Minh","68 Nguyễn Viết Xuân,Hòa Minh,Liên Chiểu,Đà Nẵng","0987654567","thunguyen@gmail.com",
                "không","không"));
    }
    @Override
    public List<Medical> findAll() {
        return medicals;
    }

    @Override
    public void createNew(Medical medical) {
        medicals.add(medical);
    }
}

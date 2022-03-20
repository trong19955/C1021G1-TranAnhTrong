package com.trongtran.ungdungdienthoai.service;

import com.trongtran.ungdungdienthoai.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();
    Phone findById(Integer id);
    void  save(Phone phone);
    void remove(Integer id);
}

package com.trongtran.ungdungdienthoai.service.impl;

import com.trongtran.ungdungdienthoai.model.Phone;
import com.trongtran.ungdungdienthoai.repository.PhoneRepository;
import com.trongtran.ungdungdienthoai.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private PhoneRepository repository;
    @Override
    public List<Phone> findAll() {
        return repository.findAll();
    }

    @Override
    public Phone findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Phone phone) {
        repository.save(phone);
    }

    @Override
    public void remove(Integer id) {
        Phone phone = findById(id);
        repository.delete(findById(id));
    }
}

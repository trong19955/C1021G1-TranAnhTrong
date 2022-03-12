package com.trongtran.service.impl;

import com.trongtran.model.Passbook;
import com.trongtran.repository.IPassbookRepository;
import com.trongtran.service.IPassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassbookService implements IPassbookService {
    @Autowired
    private IPassbookRepository repository;
    @Override
    public Page<Passbook> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Passbook passbook) {
        repository.save(passbook);
    }

    @Override
    public Passbook findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Passbook> searchByName(String name) {
        return repository.searchByName(name);
    }
}

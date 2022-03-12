package com.trongtran.service;

import com.trongtran.model.Passbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPassbookService {
    Page<Passbook> findAll(Pageable pageable);
    void save(Passbook passbook);
    Passbook findById(Integer id);
    void remove(Integer id);
    List<Passbook> searchByName(String name);
}

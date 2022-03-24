package com.trongtran.demo.service.impl;


import com.trongtran.demo.repository.IServiceRepository;
import com.trongtran.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public Page<com.trongtran.demo.model.Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable) ;
    }
}

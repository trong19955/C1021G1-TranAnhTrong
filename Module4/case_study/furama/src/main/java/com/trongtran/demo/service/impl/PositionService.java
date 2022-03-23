package com.trongtran.demo.service.impl;

import com.trongtran.demo.model.Position;
import com.trongtran.demo.repository.IPositionRepository;
import com.trongtran.demo.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}

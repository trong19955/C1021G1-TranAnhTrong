package com.trongtran.codegym.repository;

import com.trongtran.codegym.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}

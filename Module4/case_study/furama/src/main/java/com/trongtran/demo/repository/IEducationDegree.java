package com.trongtran.demo.repository;

import com.trongtran.demo.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegree extends JpaRepository<EducationDegree, Integer> {
}

package com.trongtran.demo.repository;

import com.trongtran.demo.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}

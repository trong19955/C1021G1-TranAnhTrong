package com.trongtran.codegym.service;

import com.trongtran.codegym.entity.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    void delete(int id);

    Student finById(int id);

    List<Student> searchByName(String name);
}

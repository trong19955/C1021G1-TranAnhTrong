package com.trongtran.codegym.service.impl;

import com.trongtran.codegym.model.Student;
import com.trongtran.codegym.repository.StudentRepository;
import com.trongtran.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> findByInputText(String inputSearch, Pageable pageable) {
        return studentRepository.findByName2(inputSearch, pageable);
    }
}

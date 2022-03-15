package com.trongtran.codegym.service.impl;

import com.trongtran.codegym.entity.Student;
import com.trongtran.codegym.repository.StudentRepository;
import com.trongtran.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll()  {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Student finById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> searchByName(String name) {
        return null;
    }
}

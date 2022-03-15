package com.trongtran.codegym.controller;

import com.trongtran.codegym.dto.StudentDto;
import com.trongtran.codegym.entity.Student;
import com.trongtran.codegym.service.impl.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student/api/v1")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getStudentList(){
        List<Student> studentList = studentService.findAll();
        if(studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @RequestBody StudentDto studentDto
    ){
        Student currentStudent = studentService.finById(id);
        if(currentStudent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentStudent.setName(studentDto.getName());
        currentStudent.setGender(studentDto.getGender());

        studentService.save(currentStudent);
        return new ResponseEntity<>(currentStudent,HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchByName(
            @RequestParam String name
    ){
        List<Student> studentList = studentService.searchByName(name);
        if(studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
}

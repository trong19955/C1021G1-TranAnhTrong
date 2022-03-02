package service.impl;

import model.Teacher;
import repository.ITeacherRepository;
import repository.impl.TeacherRepositoryImpl;
import service.ITeacherService;

import java.util.List;

public class TeacherServiceImpl implements ITeacherService {
    private static ITeacherRepository iTeacherRepository= new TeacherRepositoryImpl() {


    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList = iTeacherRepository.getAllStudent();
        if (teacherList.size() == 0) {
            return null;
        }
    }

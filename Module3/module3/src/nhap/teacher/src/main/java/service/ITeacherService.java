package service;

import model.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getAllTeacher();

    void saveTeacher(Teacher teacher);

    Teacher findByCodeTeacher(int idTeacher);

    void updateTeacher(Teacher teacher);

}

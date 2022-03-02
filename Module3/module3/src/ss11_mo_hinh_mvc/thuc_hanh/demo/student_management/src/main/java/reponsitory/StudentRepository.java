package reponsitory;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));
        studentList.add(new Student(1, "HaiTT", "1998-11-01", "hai.truong@codegym.vn", 9));
        studentList.add(new Student(2, "TrungDP", "1998-01-01", "hai.truong@codegym.vn", 11));
        studentList.add(new Student(3, "TrungDC", "1998-01-01", "hai.truong@codegym.vn", 7));
        studentList.add(new Student(4, "TienNVT", "1998-01-01", "hai.truong@codegym.vn", 10));

    }

    @Override
    public List<Student> getAllStudent() {
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findByCodeStudent(int codeStudent) {
        for(Student student: studentList) {
            if(student.getCodeStudent() == codeStudent) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        for(Student temp: studentList) {
            if(temp.getCodeStudent() == student.getCodeStudent()) {
                temp.setNameStudent(student.getNameStudent());
                temp.setBirthday(student.getBirthday());
                temp.setPoint(student.getPoint());
                temp.setEmail(student.getEmail());
                break;
            }
        }
    }
}


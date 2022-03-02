package controller;

import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList =new ArrayList<>();
        studentList.add(new Student(1,"haiTT", "1998/01/01", "hai.truong@gmail.com",9));
        studentList.add(new Student(2,"Trung DC", "1998/01/01", "hai.truong@gmail.com",9));
        studentList.add(new Student(3,"Trung DP", "1998/01/01", "hai.truong@gmail.com",9));
        studentList.add(new Student(4,"Tien NVT", "1998/01/01", "hai.truong@gmail.com",9));
       //gửi dữ liệu sang JSP
        request.setAttribute("list",studentList);
        // chuyển trang
        request.getRequestDispatcher("/student/student_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

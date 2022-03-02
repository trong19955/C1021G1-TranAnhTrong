package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    private static IStudentService iStudentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                int codeStudent = Integer.parseInt(request.getParameter("codeStudent"));
                String nameStudent = request.getParameter("nameStudent");
                String birthday = request.getParameter("birthday");
                String email = request.getParameter("email");
                double point = Double.parseDouble(request.getParameter("point"));
                Student student = new Student(codeStudent,nameStudent, birthday, email, point);
                iStudentService.saveStudent(student);
                response.sendRedirect("/student");
//                List<Student> studentList = iStudentService.getAllStudent();
//                request.setAttribute("list", studentList);
//                request.getRequestDispatcher("/student/student_list.jsp").forward(request, response);
                break;

            }
            case "update": {
                int codeStudent = Integer.parseInt(request.getParameter("codeStudent"));
                String nameStudent = request.getParameter("nameStudent"); //nameStudent = HaiTT
                String birthday = request.getParameter("birthday");
                String email = request.getParameter("email");
                double point = Double.parseDouble(request.getParameter("point"));
                Student student = new Student(codeStudent, nameStudent, birthday, email, point);
                iStudentService.updateStudent(student);
//                List<Student> studentList = iStudentService.getAllStudent();
//                request.setAttribute("list", studentList);
//                request.getRequestDispatcher("/student/student_list.jsp").forward(request, response);
                response.sendRedirect("/student");
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/student/create.jsp").forward(request, response);
                break;
            case "update":
                int codeStudent = Integer.parseInt(request.getParameter("codeStudent"));
                Student student = iStudentService.findByCodeStudent(codeStudent);
                request.setAttribute("student", student);
                request.getRequestDispatcher("/student/update.jsp").forward(request, response);
                break;
            default: {
                List<Student> studentList = iStudentService.getAllStudent();
                request.setAttribute("list", studentList);
                request.getRequestDispatcher("/student/student_list.jsp").forward(request, response);
            }
        }

    }
}




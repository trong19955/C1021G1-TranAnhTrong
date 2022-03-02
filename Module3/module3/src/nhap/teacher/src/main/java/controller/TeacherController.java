package controller;

import model.Teacher;
import repository.ITeacherRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherController", value = "/Teacher")
public class TeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("/teacher/create.jsp").forward(request,response);
                break;
            default: {


            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":{
                break;
            }
        }
    }
}

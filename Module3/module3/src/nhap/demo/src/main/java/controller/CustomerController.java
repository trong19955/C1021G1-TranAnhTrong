package controller;

import model.Customer;
import model.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepository;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = {"/customer"})
public class CustomerController extends HttpServlet {
    private ICustomerService iCustomerService =new CustomerService();
    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "update":
                showUpdate(request,response);
                break;

            default:
                showList(request,response);
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "updateCustomer":
                updateCustomer(request, response);
                break;
            default:
                showList(request,response);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        
    }

//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {

//
//
//        Customer customer = new Customer( codeCustomer, nameCustomer, birthdayCustomer, genderCustomer, idCardCustomer, phoneCustomer, emailCustomer,addressCustomer,idCustomerType );
//        iCustomerService.updateCustomer(customer);
//
//        response.sendRedirect("customer");
//    }
//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int codeStudent = Integer.parseInt(request.getParameter("codeStudent")); //codeStudent = 4
//        String nameStudent = request.getParameter("nameStudent"); //nameStudent = HaiTT
//        String birthday = request.getParameter("birthday");
//        String email = request.getParameter("email");
//        double point = Double.parseDouble(request.getParameter("point"));
//        Student student = new Student(codeStudent, nameStudent, birthday, email, point);
//        iStudentService.updateStudent(student);
////                List<Student> studentList = iStudentService.getAllStudent();
////                request.setAttribute("list", studentList);
////                request.getRequestDispatcher("/student/student_list.jsp").forward(request, response);
//        response.sendRedirect("/student");
//
//    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String codeCustomer = request.getParameter("customer_code");
        String nameCustomer = request.getParameter("customer_name");
        String birthdayCustomer = request.getParameter("customer_birthday");
        String genderCustomer = request.getParameter("customer_gender");
        String idCardCustomer = request.getParameter("customer_id_card");
        String phoneCustomer = request.getParameter("customer_phone");
        String emailCustomer = request.getParameter("customer_email");
        String addressCustomer = request.getParameter(" customer_address");
        int idCustomerType = Integer.parseInt(request.getParameter("customer_type_id"));
        Customer customer = new Customer(codeCustomer,
                nameCustomer,birthdayCustomer,genderCustomer,
                idCardCustomer,phoneCustomer,emailCustomer,
                addressCustomer,idCustomerType);
        iCustomerService.create(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

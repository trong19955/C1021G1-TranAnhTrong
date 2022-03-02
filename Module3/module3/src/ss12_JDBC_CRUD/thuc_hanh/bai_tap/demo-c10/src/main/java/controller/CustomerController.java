package controller;

import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.CustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = {"/customer", ""})
public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String nameCustomer = request.getParameter("name-customer");
        String customerCode = request.getParameter("code-customer");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        Customer customer = new Customer(nameCustomer, customerCode, birthday,gender,idCustomerType);
        customerService.create(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                default:
                    showList(request, response);
            }
        }

        private void showList (HttpServletRequest request, HttpServletResponse response){
            List<Customer> customerList = customerService.findAll();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void showCreate (HttpServletRequest request, HttpServletResponse response){
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            request.setAttribute("customerTypeList", customerTypeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

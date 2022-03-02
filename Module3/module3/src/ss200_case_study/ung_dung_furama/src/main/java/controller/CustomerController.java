package controller;

import model.Customer;
import model.CustomerType;
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
    private ICustomerService iCustomerService = new CustomerService();
    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = this.iCustomerService.findById(idCustomer);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.getCustomerById(id);
        RequestDispatcher dispatcher;
        if(customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.findAll();
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

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
                updateCustomer(request, response);
                break;
            case "search":
                String name = request.getParameter("name");
                System.out.println(name);
                List<Customer> customerList = iCustomerService.search(name);
                request.setAttribute("customerList", customerList);
                request.getRequestDispatcher("customer/list.jsp").forward(request, response);
                break;

            default:
                showList(request, response);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer = Integer.parseInt(request.getParameter("customer_id"));
        String codeCustomer = request.getParameter("customer_code");
        String nameCustomer = request.getParameter("customer_name");
        String birthdayCustomer = request.getParameter("customer_birthday");
        String genderCustomer = request.getParameter("customer_gender");
        String idCardCustomer = request.getParameter("customer_id_card");
        String phoneCustomer = request.getParameter("customer_phone");
        String emailCustomer = request.getParameter("customer_email");
        String addressCustomer = request.getParameter("customer_address");
        int idCustomerType = Integer.parseInt(request.getParameter("customer_type_id"));


        Customer customer = new Customer(codeCustomer,nameCustomer,
                birthdayCustomer,genderCustomer,idCardCustomer,phoneCustomer,
                emailCustomer,addressCustomer,idCustomerType);
        iCustomerService.update(idCustomer, customer);
        request.getRequestDispatcher("/customer");
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");

        }else {
            customer.setCodeCustomer(codeCustomer);
            customer.setNameCustomer(nameCustomer);
            customer.setBirthdayCustomer(birthdayCustomer);
            customer.setGenderCustomer(genderCustomer);
            customer.setIdCardCustomer(idCardCustomer);
            customer.setPhoneCustomer(phoneCustomer);
            customer.setEmailCustomer(emailCustomer);
            customer.setAddressCustomer(addressCustomer);
            customer.setIdCustomerType(idCustomerType);
            request.setAttribute("customer",customer);
            request.setAttribute("message","Customer information was updated");
//            dispatcher = request.getRequestDispatcher("/customer");

        }try{
//            dispatcher.forward(request,response);
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                nameCustomer, birthdayCustomer, genderCustomer,
                idCardCustomer, phoneCustomer, emailCustomer,
                addressCustomer, idCustomerType);
        iCustomerService.create(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controller;

import model.ListCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ListCustomer> listCustomerList = new ArrayList<>();
        listCustomerList.add(new ListCustomer("Mai Văn Hoàn", "20/08/1983", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTPjVQlCp8IN1L2l34qMYM4-umuvV4-mqdU_D4jd8hZa_RDWFfBsl5iNxrxd84mtpHpPc&usqp=CAU"));
        listCustomerList.add(new ListCustomer("Nguyễn Văn Nam", "21/08/1983", "Bắc Giang", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8iWciiRby92NLGz-l2yNQfAHnqwnWvOz96wRpwMXbaJDPiFgOvIXnhY52-jWXn1g0p_I&usqp=CAU"));
        listCustomerList.add(new ListCustomer("Nguyễn Thái Hòa", "22/08/1983", "Nam Định", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-L2tK5ArbekJ4fNmwaxd_2uqXtXgJWveXURxTasoJ6-Wfvhm0tF8eMdZt7Po5xpmn8T0&usqp=CAU"));
        listCustomerList.add(new ListCustomer("Trần Đăng Khoa", "23/08/1983", "Hà Tây", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8yI8oEeK_2A2fG8X3lNjh1irmZLJ1eLg40qSutXHzEzP_1EnCn4pQmZQWfN6jICvi1pA&usqp=CAU"));
        listCustomerList.add(new ListCustomer("Nguyễn ĐÌnh Thi", "24/08/1983", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSv9aaLUNDX7ACNeekTxPhG8VhTOvdJBzHoo1tcmFIxt6vdWT7B1cq8q8bUI6IAt94ZDMA&usqp=CAU"));

        request.setAttribute("list", listCustomerList);
        request.getRequestDispatcher("/customer/customer_list.jsp").forward(request,response);
    }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }

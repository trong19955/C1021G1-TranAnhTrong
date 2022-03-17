package com.trongtran.codegym.controller;

import com.trongtran.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"","/customer"})
    public String getAllCustomer(Model model){
        model.addAttribute("customer",iCustomerService.getAllCustomer());
        return "list";
    }
}

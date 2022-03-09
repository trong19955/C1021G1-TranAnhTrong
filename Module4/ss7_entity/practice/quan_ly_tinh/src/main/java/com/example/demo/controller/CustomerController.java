package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable){
        Page<Customer> customerPage = customerService.finAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList",customerPage);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        if (customerService.findById(id).isPresent()){
            Customer customer =  customerService.findById(id).get();
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @PostMapping("/edit")
    public String updateProvince(Customer customer) {
        customerService.save(customer);
        return "redirect:/list";
    }


    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Long id){
        customerService.remove(id);
        return "redirect:/list";
    }
    @GetMapping("/search")
    public ModelAndView searhCustomer(@PageableDefault(value = 5) Pageable pageable,@RequestParam String nameCustomer){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList",customerService.findByName(pageable,nameCustomer));
        return modelAndView;

    }
}

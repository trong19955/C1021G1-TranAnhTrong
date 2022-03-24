package com.trongtran.demo.controller;

import com.trongtran.demo.model.Customer;
import com.trongtran.demo.model.Employee;
import com.trongtran.demo.service.ICustomerService;

import com.trongtran.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ManyToOne;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customer")
    public ModelAndView home(@PageableDefault(value = 3, sort = "idCustomer", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save-customer")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customers/delete");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/delete-customer")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getIdCustomer());
        redirectAttributes.addFlashAttribute("message", "successfully deleted");
        return "redirect:/customer";
    }

    @GetMapping("/view-customer/{id}")
    public String viewCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customers/view";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        Optional<Customer> customerOptional = Optional.ofNullable(this.customerService.findById(id));
        if (customerOptional.isPresent()) {
            model.addAttribute("customer", customerService.findById(id));
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customers/edit";

        } else {
            return "error.404";
        }
    }

    @PostMapping("/update-customer")
    public String editCustomer(@ModelAttribute(name = "customer") Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "successfully update");
        return "redirect:/customer";
    }
}

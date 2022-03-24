package com.trongtran.demo.controller;

import com.trongtran.demo.dto.EmployeeDto;
import com.trongtran.demo.model.Employee;
import com.trongtran.demo.service.IDivisionService;
import com.trongtran.demo.service.IEducationDegreeService;
import com.trongtran.demo.service.IEmployeeService;
import com.trongtran.demo.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String showList() {
        return "index";
    }

    @GetMapping("/employee")
    public ModelAndView home(@PageableDefault(value = 3, sort = "employeeId", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = iEmployeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employees/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("division", iDivisionService.findAll());
        modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
        modelAndView.addObject("position", iPositionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("employees/create");
        modelAndView.addObject("employee", new EmployeeDto());
        modelAndView.addObject("division", iDivisionService.findAll());
        modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
        modelAndView.addObject("position", iPositionService.findAll());
        return modelAndView;
    }

    @PostMapping("/save-employee")
    public String save(@Validated @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employees/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            model.addAttribute("message", "Thêm mới thành công");
            iEmployeeService.save(employee);
            return "redirect:/employee";
        }

    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Employee employee = iEmployeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employees/delete");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("division", iDivisionService.findAll());
        modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
        modelAndView.addObject("position", iPositionService.findAll());
        return modelAndView;
    }
    @PostMapping("/delete-employee")
    public String delete(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.remove(employee.getEmployeeId());
        redirectAttributes.addFlashAttribute("message", "successfully deleted");
        return "redirect:/employee";
    }

    @GetMapping( "/edit-employee/{id}")
    public String showEdit(@PathVariable Integer id, Model model){
        Optional<Employee> employeeOptional = Optional.ofNullable(this.iEmployeeService.findById(id));

        if(employeeOptional.isPresent()) {
            model.addAttribute("employee", employeeOptional.get());
            model.addAttribute("division", iDivisionService.findAll());
            model.addAttribute("educationDegree", iEducationDegreeService.findAll());
            model.addAttribute("position", iPositionService.findAll());

            return "employees/edit";
        }else {
            return "error.404";
        }
    }
    @PostMapping( "/update-employee")
    public String editEmployee(@ModelAttribute(name = "employee") Employee employee, RedirectAttributes redirectAttributes){
        this.iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","successfully update");
        return "redirect:/employee";
    }
    @GetMapping("/search")
    public String search(@RequestParam (name="employeeName",required = false)String name, @PageableDefault(value = 3, sort = "employeeId", direction = Sort.Direction.ASC) Pageable pageable, Model model ){
        model.addAttribute("employeeList",iEmployeeService.findByEmployee_EmployeeName(name, pageable));
        return "/employees/list";
    }
    @GetMapping("/view-employee/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("division", iDivisionService.findAll());
        model.addAttribute("educationDegree", iEducationDegreeService.findAll());
        model.addAttribute("position", iPositionService.findAll());
        return "/employees/view";
    }
}

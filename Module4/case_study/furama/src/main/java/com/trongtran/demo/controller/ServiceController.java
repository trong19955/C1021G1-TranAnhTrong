package com.trongtran.demo.controller;

import com.trongtran.demo.model.Customer;
import com.trongtran.demo.model.Service;
import com.trongtran.demo.service.IRentTypeService;
import com.trongtran.demo.service.IService;
import com.trongtran.demo.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    @Autowired
    private IService iService;
    @Autowired
    private IServiceType iServiceType;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/service")
    public ModelAndView home(@PageableDefault(value = 3, sort = "idCustomer", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Service> services = iService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("services/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("serviceList", services);
        modelAndView.addObject("serviceTypeList", iRentTypeService.findAll());
        return modelAndView;
    }
}

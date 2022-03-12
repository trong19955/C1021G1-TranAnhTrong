package com.trongtran.controller;

import com.trongtran.model.Passbook;
import com.trongtran.service.ICustomerService;
import com.trongtran.service.IPassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/passbook")
public class PassbookController {
    @Autowired
    private IPassbookService passbookService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView home(@PageableDefault(value = 2, sort ="timeStart",direction = Sort.Direction.ASC)Pageable pageable){

        Page<Passbook> passbooks = passbookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("passbookList/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("passbookList",passbooks);
        modelAndView.addObject("customer", customerService.findAll());
        return  modelAndView;
    }

}

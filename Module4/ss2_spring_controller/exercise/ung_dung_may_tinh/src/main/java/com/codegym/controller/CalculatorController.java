package com.codegym.controller;


import com.codegym.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
   @Autowired
   CalculatorService calculatorService;

    @RequestMapping("/calculator")
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam String calculator,@RequestParam double number1 , @RequestParam double number2, Model model) {
        double ketQua = calculatorService.calculator(calculator, number1, number2);
        model.addAttribute("result", ketQua);
        return "index";

    }
}

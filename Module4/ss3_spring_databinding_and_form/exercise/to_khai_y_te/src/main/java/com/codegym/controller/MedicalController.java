package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.service.IMedicalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicalController {
    IMedicalService iMedicalService;
    @GetMapping("/list")
    public String findAll(Model model){
        List<Medical> medicals =iMedicalService.findAll();
        model.addAttribute("medicals", medicals);
        return "list";
    }
    @PostMapping("/list")
    public String createNew(@ModelAttribute Medical medical){
        iMedicalService.createNew(medical);
        return "redirect:/list";
    }
}

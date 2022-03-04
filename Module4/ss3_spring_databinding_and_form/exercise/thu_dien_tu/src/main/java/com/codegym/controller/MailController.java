package com.codegym.controller;

import com.codegym.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {
    @GetMapping({"/", "/mail"})
    public String showUpdate(Model model){
        Mail mail = new Mail("English", 25, false, "Thor King, Asgard");
        model.addAttribute("mail", mail);
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList",languageList);
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList", pageSizeList);
        return "mail";
    }

    @PostMapping({"/", "/mail"})
    public String update(@ModelAttribute("mail") Mail mail, Model model) {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList", languageList);
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("message", "Update successful");
        return "mail";
    }
}

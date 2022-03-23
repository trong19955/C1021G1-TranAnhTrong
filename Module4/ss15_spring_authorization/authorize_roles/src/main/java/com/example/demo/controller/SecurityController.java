package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    private String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }

    @GetMapping(value = {"/","/home"})
    public String homePage(Model model) {
        model.addAttribute("user",getPrincipal());
        return "/welcome";
    }

    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("admin",getPrincipal());
        return "/admin";
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage(ModelMap modelMap) {
        modelMap.addAttribute("user",getPrincipal());
        return "access-denied";
    }

    @GetMapping("/dba")
    public String dbaPage(ModelMap modelMap) {
        modelMap.addAttribute("user",getPrincipal());
        return "dba";
    }

}

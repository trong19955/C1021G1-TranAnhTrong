package com.example.demo.controller;

import com.example.demo.model.Code;
import com.example.demo.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private ICodeService codeService;
    @GetMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("code/list","codeList",codeService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView =new ModelAndView("code/create");
        modelAndView.addObject("codeList", new Code());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Code code, RedirectAttributes redirectAttributes){
        codeService.save(code);
        redirectAttributes.addFlashAttribute("message","thêm mới thành công");
        return "redirect:/code/list";
    }
}

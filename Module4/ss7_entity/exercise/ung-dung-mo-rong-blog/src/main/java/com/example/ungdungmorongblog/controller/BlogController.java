package com.example.ungdungmorongblog.controller;

import com.example.ungdungmorongblog.service.IBlogService;
import com.example.ungdungmorongblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Qualifier("blogService")
    @Autowired
    private IBlogService blogService;


    @GetMapping(value = "/list")
    public ModelAndView showBlogList(@PageableDefault(value = 5,sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        return new ModelAndView("list","blogList",blogService.findAll(pageable));
    }

}

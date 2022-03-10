package com.example.ungdungmorongblog.controller;

import com.example.ungdungmorongblog.model.Blog;
import com.example.ungdungmorongblog.service.IBlogService;
import com.example.ungdungmorongblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public ModelAndView home(@PageableDefault(value = 5, sort = "dateStart" , direction = Sort.Direction.ASC) Pageable pageable){

        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("blogList/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("blogList", blogs);
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("blogList/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateStart(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công!");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Integer id){
        Blog blog =blogService.findById(id);
        ModelAndView modelAndView =new ModelAndView("blogList/delete");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message","successfully deleted");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Integer id){
        Blog blog =blogService.findById(id);
        ModelAndView modelAndView =new ModelAndView("blogList/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blog.setDateStart(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","successfully updated");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blogList/view");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView searchBlog(@RequestParam(name = "kq", required = false) String keyword){
        return new ModelAndView("blogList/list","blogList", blogService.searchByName(keyword));
    }
}

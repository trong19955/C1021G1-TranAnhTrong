package com.example.ungdungmorongblog.controller;

import com.example.ungdungmorongblog.model.Blog;
import com.example.ungdungmorongblog.model.Category;
import com.example.ungdungmorongblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("category/list", "categoryList", categoryService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("categoryList", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Thêm mới category thành công!");
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/delete");
        modelAndView.addObject("categoryList", category);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message","successfully deleted");
        return "redirect:/category/list";

    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("categoryList", category);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "successfully update!");
        return "redirect:/category/list";
    }

}


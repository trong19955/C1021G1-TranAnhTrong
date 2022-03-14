package com.trongtran.codegym.controller;

import com.trongtran.codegym.model.Product;
import com.trongtran.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView home(@PageableDefault(value = 2,direction = Sort.Direction.ASC) Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("productList", products);
        return new ModelAndView("list", "productList", productService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public ModelAndView save(Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.addObject("message", "Thêm mới bolog thành công!");
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
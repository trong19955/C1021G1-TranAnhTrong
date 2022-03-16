package com.trongtran.codegym.controller;

import com.trongtran.codegym.model.Cart;
import com.trongtran.codegym.model.Product;
import com.trongtran.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/home")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") Cart cart,
                            @RequestParam(value = "action", required = false, defaultValue = "") String action, Model model) {
        Optional<Product> product = this.productService.findById(id);

        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.addProduct(product.get());
        model.addAttribute("mess","Add product successfully!!");
        return "redirect:/cart";
    }

    @GetMapping("/view/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Product> product = this.productService.findById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "/view";
        }else {
            return "error.404";
        }
    }
}
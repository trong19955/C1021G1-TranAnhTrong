package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.ServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Remove product successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @GetMapping("/{name}/search")
    public String search(@PathVariable String name, Model model){
        model.addAttribute("product", productService.findByName(name));
        return "/search";
    }
    @PostMapping("/search")
    public String findByName(Product product, @RequestParam String name){
        product.search(product, product.getName());
        return "/search";
    }
}

package com.example.demo.controller;

//import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductService;
import com.example.demo.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeService iTypeService;


    @GetMapping("/products")
    public ModelAndView home(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Product> products = iProductService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("productList", products);
        modelAndView.addObject("typeList", iTypeService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("products/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("type", iTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công!");
        return "redirect:/product";
    }


    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("products/delete");
        modelAndView.addObject("product", product);
        modelAndView.addObject("type", iTypeService.findAll());

        return modelAndView;
    }

    @PostMapping("/remove")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "successfully deleted");
        return "redirect:/products";
    }

}


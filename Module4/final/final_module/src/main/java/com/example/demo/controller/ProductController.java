package com.example.demo.controller;


import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/product")
    public ModelAndView list(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Product> products = iProductService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("products/list");
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
    public String save(@Validated @ModelAttribute("product") ProductDto productDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("type", iTypeService.findAll());
            return "products/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            model.addAttribute("message", "thêm mới thành công");
            iProductService.save(product);
            return "redirect:/product";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("products/delete");
        modelAndView.addObject("product", product);
        modelAndView.addObject("type", iTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "successfully deleted");
        return "redirect:/product";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id,Model model){
        Product product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        if(product !=null){
            model.addAttribute("product", productDto);
            model.addAttribute("type", iTypeService.findAll());
            return "products/edit";
        }else {
            return "error.404";
        }
    }
    @PostMapping("/update")
    public String editProduct(@Validated @ModelAttribute(name="product") ProductDto productDto, BindingResult bindingResult,Model model){
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        if(bindingResult.hasFieldErrors()){
            model.addAttribute("type", iTypeService.findAll());
            return "products/edit";
        }else {
            this.iProductService.save(product);
            model.addAttribute("message", "successfully update");
            return "redirect:/product";
        }
    }

}


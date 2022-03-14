package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import com.example.demo.service.ICodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeService codeService;

    @GetMapping("")
    public ModelAndView home(@PageableDefault(value = 5, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("list", "ok");
        modelAndView.addObject("bookList", books);
        modelAndView.addObject("code", codeService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("code", codeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public  String save(@ModelAttribute Book book, RedirectAttributes redirectAttributes ){
        book.setBookLoanDay( new Date(System.currentTimeMillis()));
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","thêm mới thành công");
        return "redirect:/book";
    }
}

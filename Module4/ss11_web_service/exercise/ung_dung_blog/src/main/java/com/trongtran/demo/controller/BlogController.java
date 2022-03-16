package com.trongtran.demo.controller;

import com.trongtran.demo.model.Blog;
import com.trongtran.demo.model.Category;
import com.trongtran.demo.repository.ICategoryRepository;
import com.trongtran.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService service;
    @Autowired
    private ICategoryRepository repository;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) service.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Integer id){
        Optional<Blog> blogOptional=service.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategories() {
        List<Category> categories = this.repository.findAll();
        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Blog>> findBlogByCategoryID(@PathVariable Integer id) {
        List<Blog> blogs = (List<Blog>) this.service.findAllByCategoryId(id);

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}

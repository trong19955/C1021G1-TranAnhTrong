package com.trongtran.ungdungdienthoai.controller;

import com.trongtran.ungdungdienthoai.model.Phone;
import com.trongtran.ungdungdienthoai.service.IPhoneService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private IPhoneService service;

    @GetMapping("/list")
    public ModelAndView showPhoneList() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("phones", service.findAll());
        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<List<Phone>> createPhone(@RequestBody Phone phone) {
        service.save(phone);
        return new ResponseEntity<>(service.findAll(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Phone>> allPhones() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Phone>> deletePhone(@PathVariable Integer id) {
        Phone phone = service.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Integer id, @RequestBody Phone phone) {
        Phone phones = service.findById(id);
        if (phones == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phones.setProducer(phone.getProducer());
        phones.setDescription(phone.getDescription());
        phones.setPrice(phone.getPrice());
        service.save(phones);

        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

}


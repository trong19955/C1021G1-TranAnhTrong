package com.example.demo.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class BookDto implements Validator {
    private Integer id;
    @Size(min =4, max= 45)
    private String name;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")
    private Date bookLoanDay;
    @Size(min =0 ,max= 10)
    private Integer deposits;

    public BookDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBookLoanDay() {
        return bookLoanDay;
    }

    public void setBookLoanDay(Date bookLoanDay) {
        this.bookLoanDay = bookLoanDay;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto bookDto =(BookDto) target;
        if("".equals(bookDto.getName())){
            errors.rejectValue("name","","Không được để trống");
        }
        if ("".equals(bookDto.getBookLoanDay())){
            errors.rejectValue("bookLoanDay","","không dược để trống book loan day ");
        }
        if("".equals(bookDto.getDeposits())){
            errors.rejectValue("deposits","","Không được dể trống deposits");
        }
    }
}

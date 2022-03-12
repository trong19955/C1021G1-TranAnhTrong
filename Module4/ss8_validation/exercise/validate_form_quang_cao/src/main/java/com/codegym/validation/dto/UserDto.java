package com.codegym.validation.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;
    @Size(min = 4,max = 45)
    private String firstName;
    @Size(min = 4,max = 45)
    private String lastname ;
    @Size(min = 0,max = 10)
    private String phoneNumber;
    @Min(18)
    private int age ;
    @Email
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto useDto = (UserDto) target;
        if ("".equals(useDto.getFirstName())){
            errors.rejectValue("firstName","","Không được để trống");
        }
        if ("".equals(useDto.getLastname())){
            errors.rejectValue("lastname","","Không được trống lastName");
        }

        if ("".equals(useDto.getPhoneNumber())){
            errors.rejectValue("phoneNumber","","Số điện thoại phải là 10 số");
        }
        if ("".equals(useDto.getPhoneNumber())){
            errors.rejectValue("age","","Tuổi phải lớn hơn 18");
        }
        if ("".equals(useDto.getEmail())){
            errors.rejectValue("email","","Email không đúng định dạng");
        }

    }
}
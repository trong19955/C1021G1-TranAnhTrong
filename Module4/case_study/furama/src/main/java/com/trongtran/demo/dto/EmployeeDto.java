package com.trongtran.demo.dto;

import com.trongtran.demo.model.Division;
import com.trongtran.demo.model.EducationDegree;
import com.trongtran.demo.model.Position;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
public class EmployeeDto implements Validator {
    private Integer employeeId;
    @NotBlank
    private String employeeName;

    private String employeeBirthday;
    @Pattern(regexp = "^[0-9]{12}$", message = "hãy nhập đúng định dạng 12 số")
    private String employeeIdCard;

    @Min(value = 0,message = "nhập thêm vài chai đi")
    @Max(value = 10000000,message = "Nhập nhỏ hơn 10chai")
    private Double employeeSalary;
    @Pattern(regexp = "\\+?(0|84)\\d{9,10}", message = "hãy nhập đúng định dạng ví du:+84981967705")
    private String employeePhone;
    @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = "hãy nhậy đúng định dạng ví dụ:trong@gmail.com")
    private String employeeEmail;
    @NotBlank
    private String employeeAddress;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if ("".equals(employeeDto.getEmployeeSalary())) {
            errors.rejectValue("employeeSalary", "", "Hãy Nhập Đúng vd:1234");
        }
//        else if (employeeDto.getEmployeeSalary() < 10000000 && employeeDto.getEmployeeSalary() > 0) {
//            errors.rejectValue("employeeSalary", "", "lương phải nhỏ hơn 10 triệu");
//        } else {
//            errors.rejectValue("employeeSalary", "", "hãy nhập số" );
//        }

//        if("".equals(employeeDto.getEmployeeName())){
//            errors.rejectValue("employeeName","","");
//        }
//        if("".equals(employeeDto.getEmployeeBirthday())){
//            errors.rejectValue("employeeBirthday","");
//        }
//        if("".equals(employeeDto.getEmployeeIdCard())){
//            errors.rejectValue("employeeIdCard","");
//        }
//        if("".equals(employeeDto.getEmployeePhone())){
//            errors.rejectValue("employeePhone","");
//        }
//        if("".equals(employeeDto.getEmployeeEmail())){
//            errors.rejectValue("employeeEmail","");
//        }
    }
}

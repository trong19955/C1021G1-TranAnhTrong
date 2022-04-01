//package com.example.demo.dto;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Pattern;
//
//
//@Component
//public class TransactionDto implements Validator {
//    private Integer idTransaction;
//    @Pattern(regexp = "^MGD-[0-9]{4}", message = "Hãy nhập đúng định dạng vi dụ:MGD-1111")
//    private String codeTransaction;
//    private String nameTransaction;
//    private String dateTransaction;
//
//    @Min(value = 0, message = "dfgfdg")
//    private Double priceTransaction;
//
//    private String Area;
//    private ServiceType serviceType;
//    private Customer customer;
//
//    public Integer getIdTransaction() {
//        return idTransaction;
//    }
//
//    public void setIdTransaction(Integer idTransaction) {
//        this.idTransaction = idTransaction;
//    }
//
//    public String getCodeTransaction() {
//        return codeTransaction;
//    }
//
//    public void setCodeTransaction(String codeTransaction) {
//        this.codeTransaction = codeTransaction;
//    }
//
//    public String getNameTransaction() {
//        return nameTransaction;
//    }
//
//    public void setNameTransaction(String nameTransaction) {
//        this.nameTransaction = nameTransaction;
//    }
//
//    public String getDateTransaction() {
//        return dateTransaction;
//    }
//
//    public void setDateTransaction(String dateTransaction) {
//        this.dateTransaction = dateTransaction;
//    }
//
//    public Double getPriceTransaction() {
//        return priceTransaction;
//    }
//
//    public void setPriceTransaction(Double priceTransaction) {
//        this.priceTransaction = priceTransaction;
//    }
//
//    public String getArea() {
//        return Area;
//    }
//
//    public void setArea(String area) {
//        Area = area;
//    }
//
//    public ServiceType getServiceType() {
//        return serviceType;
//    }
//
//    public void setServiceType(ServiceType serviceType) {
//        this.serviceType = serviceType;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//    }
//}

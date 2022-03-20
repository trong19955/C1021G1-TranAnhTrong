package com.trongtran.codegym.dto;

import com.trongtran.codegym.model.Customer;
import com.trongtran.codegym.model.ServiceType;
import com.trongtran.codegym.validation.RegexPattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ContractDto implements Validator {

    protected Integer contractId;

    private Customer customer;

    @NotBlank(message = "Contract date not blank!")
    protected String contractDate;

    private ServiceType serviceType;

    //    @Pattern(regexp = RegexPattern.REGEX_POSITIVE_INTEGER,message = "Price must be a number!")
    protected Double price;

    protected Double area;

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ContractDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        Double price = contractDto.price;

        if (price == null)
            errors.rejectValue("price","price.null");
        else {
            if (price <= 500000)
                errors.rejectValue("price","price.min");
        }

        Double area = contractDto.area;

        if (area == null)
            errors.rejectValue("area","area.null");
        else {
            if (area <= 20)
                errors.rejectValue("area","area.min");
        }

        String contractDate = contractDto.contractDate;

        if (RegexPattern.validateDate(contractDate))
            errors.rejectValue("contractDate","contractDate.check");

    }
}

package com.trongtran.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer contractId;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    protected String contractDate;

    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;

    protected Double price;
    protected Double area;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
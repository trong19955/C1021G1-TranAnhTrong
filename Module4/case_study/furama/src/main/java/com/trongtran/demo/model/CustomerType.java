package com.trongtran.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomerType;
    private String nameCustomerType;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private Set<Customer> customers;
    public CustomerType() {
    }

    public Integer getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(Integer idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}

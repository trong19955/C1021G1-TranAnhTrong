package com.trongtran.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCustomer;
@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
private Set<Passbook> passbook;
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Set<Passbook> getPassbook() {
        return passbook;
    }

    public void setPassbook(Set<Passbook> passbook) {
        this.passbook = passbook;
    }
}

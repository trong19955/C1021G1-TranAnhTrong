package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;
    private String nameType;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Type() {
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

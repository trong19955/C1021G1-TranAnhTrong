package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double price;
    private String status;
    @ManyToOne
    @JoinColumn(name ="type_id", referencedColumnName = "idType")
    private Type type;

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

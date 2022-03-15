package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Code {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;

    @OneToMany(mappedBy = "code", cascade = CascadeType.ALL)
    private Set<Book> book;
    public Code() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

}

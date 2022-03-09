package com.example.ungdungmorongblog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBlog;
    private Date dateStart;

    @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

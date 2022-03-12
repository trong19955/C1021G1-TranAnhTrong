package com.trongtran.model;

import javax.persistence.*;

@Entity
public class Passbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // mã số sổ
    private String name; // tên sổ
    private String timeStart;//thời gian bắt đầu gửi
    private String period; //kỳ hạn
    private Integer money; //số tiền gửi

    @ManyToOne
    @JoinColumn(name ="customer_id", referencedColumnName = "id" )
    private Customer customer;
    public Passbook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

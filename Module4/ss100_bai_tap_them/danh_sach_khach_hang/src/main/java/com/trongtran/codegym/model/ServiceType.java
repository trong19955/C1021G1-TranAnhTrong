package com.trongtran.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer serviceTypeId;
    protected String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private List<Contract> contracts;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

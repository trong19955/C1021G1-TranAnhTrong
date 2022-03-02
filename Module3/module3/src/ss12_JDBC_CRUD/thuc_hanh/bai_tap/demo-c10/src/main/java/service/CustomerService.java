package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void create(Customer customer);
    void delete(int id);
}

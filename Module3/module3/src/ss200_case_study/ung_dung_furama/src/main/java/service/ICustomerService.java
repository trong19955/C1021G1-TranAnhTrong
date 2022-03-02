package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);

    void update(int id, Customer customer);

    Customer getCustomerById(int id);

    Customer findById(int id);


    List<Customer> search(String name);
}


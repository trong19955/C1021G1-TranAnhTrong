package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);
}

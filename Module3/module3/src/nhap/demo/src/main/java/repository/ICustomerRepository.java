package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);

    void updateCustomer(Customer customer);
}

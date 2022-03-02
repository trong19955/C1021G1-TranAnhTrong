package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.create(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.delete(id);
    }

    @Override
    public void update(int id, Customer customer) {
        iCustomerRepository.update(id,customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return iCustomerRepository.getCustomerById(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> search(String name) {
        return iCustomerRepository.search(name);
    }

}

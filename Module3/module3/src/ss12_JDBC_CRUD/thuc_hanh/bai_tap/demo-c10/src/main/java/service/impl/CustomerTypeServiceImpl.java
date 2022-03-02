package service.impl;

import model.CustomerType;
import repository.CustomerTypeRepository;
import repository.impl.CustomerTypeRepositoryImpl;
import service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}

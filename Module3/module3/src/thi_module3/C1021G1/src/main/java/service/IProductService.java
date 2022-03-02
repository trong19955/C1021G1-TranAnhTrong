package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    void delete(int id);


    List<Product> search(String name);



    void update(int id, Product product);

    Product getProductById(int id);



}

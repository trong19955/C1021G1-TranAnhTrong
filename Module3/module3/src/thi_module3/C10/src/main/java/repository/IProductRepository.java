package repository;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product customer);

    void delete(int id);

    List<Product> search(String name);

    List<Product> searchById(int id);

    void update(int id, Product product);

    Product getProductById(int id);
}


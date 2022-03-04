package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private  static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Samsum","12000000", "Sản phẩm chất lượng cao","Japan"));
        products.put(2, new Product(2,"Oppo","11000000", "Sản phẩm chất lượng cao","Japan"));
        products.put(3, new Product(3,"Iphone","12000000", "Sản phẩm chất lượng cao","USA"));
        products.put(4, new Product(4,"V_smart","12000000", "Sản phẩm chất lượng cao","VN"));
        products.put(5, new Product(5,"Xiaomy","12000000", "Sản phẩm chất lượng cao","China"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }


    @Override
    public Product findByName(String name) {
        return products.get(name);
    }
}

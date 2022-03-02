package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        List<Product> productList = iProductRepository.findAll();
        if(productList.size()== 0){
            return null;
        }
        return iProductRepository.findAll();
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }

    @Override
    public List<Product> searchById(int id) {
        return iProductRepository.searchById(id);
    }
}

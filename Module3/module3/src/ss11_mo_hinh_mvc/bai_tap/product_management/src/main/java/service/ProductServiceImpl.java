package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Samsum","10000000", "100% pro","Japan"));
        products.put(2, new Product(2,"Oppo","12000000", "100% tiện lợi", "Japan"));
        products.put(3, new Product(3,"Xiaomi","8000000","Cưc rẻ","China"));
        products.put(4, new Product(4,"iphone","15000000","Pin Trâu","U.A"));
        products.put(5, new Product(5,"Vinsmart", "12000000", "Hàng VietNam","VietNam"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
    @Override
    public List<Product>  searchByName(String name) {
        List<Product> products = this.findAll();
        List<Product> productResult = new ArrayList<>();
        String productName;
        name = name.toLowerCase();
        for (Product product:products) {
            productName = product.getName().toLowerCase();
            if (productName.contains(name)){
                productResult.add(product);
            }
        }
        return productResult;

    }
}

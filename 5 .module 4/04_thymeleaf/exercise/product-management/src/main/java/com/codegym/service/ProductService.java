package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "productService")
public class ProductService implements IProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Iphone 13 Pro Max", 2000, "Smart phone Iphone 13 Pro Max 128GB", "Apple"));
        products.put(2, new Product(2, "Iphone 12 Pro Max", 1800, "Smart phone Iphone 12 Pro Max 256GB", "Apple"));
        products.put(3, new Product(3, "Samsung A50", 400, "Smart phone Samsung A50 ", "Samsung"));
    }


    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>(products.values());
        return productList;
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
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Set<Integer> ketSet = products.keySet();
        for (Integer key: ketSet) {
            if (products.get(key).getName().contains(name)){
                productList.add(products.get(key));
            }
        }
        return productList;
    }
}

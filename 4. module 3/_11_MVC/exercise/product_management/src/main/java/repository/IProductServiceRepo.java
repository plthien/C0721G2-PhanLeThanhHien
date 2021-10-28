package repository;

import bean.Product;

import java.util.ArrayList;

public interface IProductServiceRepo {
    ArrayList<Product> findAll();
    void save(Product product);
    Product findByName(String name);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}

package repository.Impl;

import bean.Product;
import repository.IProductServiceRepo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ProductServiceRepoImpl implements IProductServiceRepo {
    static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone 13 Pro Max", 2500, "Apple smartphone 256GB", "Apple"));
        productMap.put(2, new Product(2, "Samsung Galaxy Note 10", 3000, "Samsung smartphone 5G 256GB", "Samsung"));
        productMap.put(3, new Product(3, "Iphone 12 Pro Max", 1000, "Apple smartphone 128GB", "Apple"));
        productMap.put(4, new Product(4, "Bphone 5", 900, "Bphone 5 5G RAM 16GB", "BKAV"));
        productMap.put(5, new Product(5, "Redmi Note 5", 800, "Xiaomi smartphone 128GB", "Xiaomi"));
    }

    @Override
    public ArrayList<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findByName(String name) {
        Set<Integer> set = productMap.keySet();
        for (Integer key : set) {
            if (productMap.get(key).getName().contains(name)){
                return productMap.get(key);
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);

    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}

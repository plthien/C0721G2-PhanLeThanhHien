package service.Impl;

import bean.Product;
import repository.IProductServiceRepo;
import repository.Impl.ProductServiceRepoImpl;
import service.IProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements IProductService {
    private IProductServiceRepo iProductServiceRepo = new ProductServiceRepoImpl();

    @Override
    public ArrayList<Product> findAll() {
        return iProductServiceRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductServiceRepo.save(product);
    }

    @Override
    public Product findByName(String name) {
        return iProductServiceRepo.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return iProductServiceRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductServiceRepo.update(id,product);
    }

    @Override
    public void remove(int id) {
        iProductServiceRepo.remove(id);
    }
}

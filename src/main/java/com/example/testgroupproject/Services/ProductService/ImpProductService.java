package com.example.testgroupproject.Services.ProductService;

import com.example.testgroupproject.Models.Product;
import com.example.testgroupproject.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ImpProductService implements ProdServiceInterface {

    //Injecting The repository for the Entity Product which extends JpaRepository with build in Methods via the Interface from Services
    @Autowired
    ProductRepo productRepo;

    @Override
    public void insertProduct(Product p) {
        Product savedProduct = productRepo.save(p);
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void updateProduct(Product p) {
        productRepo.save(p);
    }

    @Override
    public List<Product> getProductsByCounty(Integer countyId) {
        return productRepo.findProductByCounty_Id(countyId);
    }

    @Override
    public List<Product> getRandomProductsById(Integer id) {
        return null;
    }

    @Override
    public void deleteProduct(Product p) {
        productRepo.delete(p);
    }

}

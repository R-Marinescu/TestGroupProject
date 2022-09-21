package com.example.testgroupproject.Services.ProductService;


import com.example.testgroupproject.Models.Product;

import java.util.List;

public interface ProdServiceInterface {

    //----------- Start Product CRUD
    void insertProduct(Product p);

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    void deleteProduct(Product p);

    void updateProduct(Product p);
    //----------- End of Product Crud

  //  List<Product> findProductByFkCounty_Id(String pName, String prodInfo, Double price);

}

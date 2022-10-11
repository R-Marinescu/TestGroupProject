package com.example.testgroupproject.Services.ProdOrderService;

import com.example.testgroupproject.Models.ProductsOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class ImpProdOrderService implements ProdOrderServiceInterface{

    @Autowired
    ProductsOrder prodOrder;


    @Override
    public void insertOrderProducts(ProductsOrder o) {

    }
}

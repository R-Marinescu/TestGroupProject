package com.example.testgroupproject.Repositories;


import com.example.testgroupproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


    @Query(value = "select * from products join county on FK_county_ID = county_id Where county_id = :id", nativeQuery = true)
    List<Product> findProductByCounty_Id(@Param("id") Integer id);
//    List<Product> findByProductName(String productName);
//
//    List<Product> findByProductPrice(double productPrice);
}

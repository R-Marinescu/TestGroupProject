package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.ProductsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOrderRepo extends JpaRepository<ProductsOrder, Integer> {
}

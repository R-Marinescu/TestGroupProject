package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {


}

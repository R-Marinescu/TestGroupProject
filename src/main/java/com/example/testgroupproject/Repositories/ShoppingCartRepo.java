package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.CartItem;
import com.example.testgroupproject.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findBySessionToken(String sessionToken);

   // Set<CartItem> findAllByid



}

package com.example.testgroupproject.Services.ShoppingCartService;


import com.example.testgroupproject.Models.ShoppingCart;

import java.util.Set;

public interface ShoppingCartService {
    ShoppingCart addShoppingCartFirstTime(Integer id, String sessionToken, int quantity);

    ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity);


    ShoppingCart getShoppingCartBySessionToken(String sessionToken);

    void updateShoppingCartItem(Long id, int quantity);
}

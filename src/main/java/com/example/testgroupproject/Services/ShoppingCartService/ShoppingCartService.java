package com.example.testgroupproject.Services.ShoppingCartService;


import com.example.testgroupproject.Models.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addShoppingCartFirstTime(Integer id, String sessionToken, int quantity);

    ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity);

}

package com.example.testgroupproject.Services.ShoppingCartService;

import com.example.testgroupproject.Models.CartItem;
import com.example.testgroupproject.Models.Product;
import com.example.testgroupproject.Models.ShoppingCart;
import com.example.testgroupproject.Repositories.ShoppingCartRepo;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {

    @Autowired
    ShoppingCartRepo shoppingCartRepo;
    @Autowired
    ProdServiceInterface prodService;

    @Override
    public ShoppingCart addShoppingCartFirstTime(Integer id, String sessionToken, int quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setDate(new Date());
        cartItem.setProduct(prodService.getProductById(id));
        shoppingCart.getItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        return shoppingCartRepo.save(shoppingCart);

    }

    @Override
    public ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity) {

        ShoppingCart shoppingCart = shoppingCartRepo.findBySessionToken(sessionToken);
        Product p = prodService.getProductById(id);
        for(CartItem item: shoppingCart.getItems()) {
             if(p.getId().equals(item.getProduct().getId())) {
                 item.setQuantity(item.getQuantity()+quantity);
                 return shoppingCartRepo.save(shoppingCart);
             }
        }
        CartItem cartItem = new CartItem();
        cartItem.setDate(new Date());
        cartItem.setQuantity(quantity);
        cartItem.setProduct(p);
        shoppingCart.getItems().add(cartItem);
        return shoppingCartRepo.save(shoppingCart);
    }
}

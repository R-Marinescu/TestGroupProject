package com.example.testgroupproject.Services.ShoppingCartService;

import com.example.testgroupproject.Models.CartItem;
import com.example.testgroupproject.Models.Product;
import com.example.testgroupproject.Models.ShoppingCart;
import com.example.testgroupproject.Repositories.ShoppingCartRepo;
import com.example.testgroupproject.Services.ProductService.ProdServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

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
        shoppingCart.setDate(new Date());
        return shoppingCartRepo.save(shoppingCart);

    }

    @Override
    public ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity) {

        ShoppingCart shoppingCart = shoppingCartRepo.findBySessionToken(sessionToken);
        Product p = prodService.getProductById(id);
        Boolean productDoesExistInTheCart = false;
        if (shoppingCart != null){
            Set<CartItem> items = shoppingCart.getItems();
            for (CartItem item : items){
                
                if (item.getProduct().equals(p)) {
                    productDoesExistInTheCart = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    shoppingCart.setItems(items);
                    return shoppingCartRepo.saveAndFlush(shoppingCart);
                }
            }
        }
        if(!productDoesExistInTheCart && (shoppingCart != null))
        {
            CartItem cartItem1 = new CartItem();
            cartItem1.setDate(new Date());
            cartItem1.setQuantity(quantity);
            cartItem1.setProduct(p);
            shoppingCart.getItems().add(cartItem1);
            return shoppingCartRepo.saveAndFlush(shoppingCart);
        }
        return this.addShoppingCartFirstTime(id, sessionToken, quantity);

    }



}

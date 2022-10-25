package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.CartItem;
import com.example.testgroupproject.Models.ShoppingCart;
import com.example.testgroupproject.Repositories.ShoppingCartRepo;
import com.example.testgroupproject.Services.ShoppingCartService.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class CartController {

    @Autowired
    ShoppingCartRepo shoppingCartRepo;
    @Autowired
    ShoppingCartService shoppingCartService;


    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id")Integer id,
                            @RequestParam("quantity") int quantity) {

        //sessionToken
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken == null){

            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            shoppingCartService.addShoppingCartFirstTime(id,sessionToken,quantity);
        }else {
            shoppingCartService.addToExistingShoppingCart(id,sessionToken,quantity);

        }
        return "redirect:/";

    }

    @GetMapping("/ShoppingCart")
    public String showShoppingCartView(HttpServletRequest request, Model model) {

        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken == null){
            model.addAttribute("shoppingCart", new ShoppingCart());
        }
        else{
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionToken(sessionToken);
            model.addAttribute("shoppingCart", shoppingCart);
        }
        return "ShoppingCart";
    }

    @PostMapping("/updateShoppingCart")
    public String updateCartItem(@RequestParam("item_id")Long id,
                                 @RequestParam("quantity") int quantity){

        shoppingCartService.updateShoppingCartItem(id, quantity);
        return "ShoppingCart";
    }

}

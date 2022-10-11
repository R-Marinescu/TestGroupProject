package com.example.testgroupproject.Controllers;

import com.example.testgroupproject.Models.Order;
import com.example.testgroupproject.Services.OrderService.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    OrderServiceInterface orderService;

    @PostMapping("/insertOrder")
    public String insertOrder(@RequestParam("paymentType") String paymentType,
                              ModelMap mm) {

        Order order = new Order(paymentType);
        orderService.insertOrder(order);

        mm.addAttribute("orders", orderService.getAllOrders());
        return "Order/OrderList";
    }


}

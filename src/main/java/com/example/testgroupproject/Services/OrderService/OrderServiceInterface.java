package com.example.testgroupproject.Services.OrderService;


import com.example.testgroupproject.Models.Order;

import java.util.List;

public interface OrderServiceInterface {

    void insertOrder(Order o);

    List<Order> getAllOrders();
}

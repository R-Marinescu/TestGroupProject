package com.example.testgroupproject.Services.OrderService;

import com.example.testgroupproject.Models.Order;
import com.example.testgroupproject.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpOrderService implements OrderServiceInterface {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public void insertOrder(Order o) {
        Order savedOrder = orderRepo.save(o);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}

package com.example.testgroupproject.Repositories;

import com.example.testgroupproject.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}

package com.example.cs_module.repository.order;

import com.example.cs_module.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderRepository extends JpaRepository<Order, Integer> {
}

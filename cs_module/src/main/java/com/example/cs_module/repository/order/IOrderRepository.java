package com.example.cs_module.repository.order;

import com.example.cs_be_module4.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}

package com.example.cs_module.repository.order;

import com.example.cs_module.model.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query(value = "select c.customerName, e.name as employeeName, od.quantity, cf.name as coffeeShopName, p.name, od.totalMoney from OrderDetail od \n" +
            "join od.coffeeShop cf\n" +
            "join od.product p\n" +
            "join od.order o\n" +
            "join o.customer c\n" +
            "join o.employee e", nativeQuery = false)
    List<OrderDetail> listAllOrderInfo();
}

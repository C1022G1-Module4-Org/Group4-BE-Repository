package com.example.cs_module.repository.order;

import com.example.cs_module.model.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query(value = "select * from order_detail od", nativeQuery = true)
    List<OrderDetail> listAllOrderInfo();
}

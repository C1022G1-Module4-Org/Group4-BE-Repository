package com.example.cs_module.service.order;

import com.example.cs_module.dto.order.OrderDetailDTO;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetailDTO> findAll();
    void createOrder (OrderDetailDTO orderDetailDTO);
    void deleteOrder (int id);
}

package com.example.cs_module.service.order.impl;

import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.dto.order.OrderDTO;
import com.example.cs_module.dto.order.OrderDetailDTO;
import com.example.cs_module.model.order.OrderDetail;
import com.example.cs_module.repository.order.IOrderDetailRepository;
import com.example.cs_module.service.order.IOrderDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetailDTO> findAll() {
        List<OrderDetail> orderDetailList = orderDetailRepository.listAllOrderInfo();
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        OrderDetailDTO orderDetailDTO;
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderDTO(new OrderDTO());
            orderDetailDTO.setCoffeeShopDTO(new CoffeeShopDTO());
            BeanUtils.copyProperties(orderDetail.getOrder().getCustomer(), orderDetailDTO.getOrderDTO().getCustomerDTO());
            BeanUtils.copyProperties(orderDetail.getOrder().getEmployee(), orderDetailDTO.getOrderDTO().getEmployeeDTO());
            BeanUtils.copyProperties(orderDetail.getCoffeeShop(), orderDetailDTO.getCoffeeShopDTO());
            BeanUtils.copyProperties(orderDetail, orderDetailDTO);
            orderDetailDTOList.add(orderDetailDTO);
        }
        return orderDetailDTOList;
    }
}

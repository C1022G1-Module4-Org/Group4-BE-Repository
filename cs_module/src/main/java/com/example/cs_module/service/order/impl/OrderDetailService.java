package com.example.cs_module.service.order.impl;

import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.dto.order.OrderDTO;
import com.example.cs_module.dto.order.OrderDetailDTO;
import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.model.coffee_shop.CoffeeShop;
import com.example.cs_module.model.order.Order;
import com.example.cs_module.model.order.OrderDetail;
import com.example.cs_module.model.product.Product;
import com.example.cs_module.repository.coffee_shop.ICoffeeShopRepository;
import com.example.cs_module.repository.order.IOrderDetailRepository;
import com.example.cs_module.repository.order.IOrderRepository;
import com.example.cs_module.service.order.IOrderDetailService;
import com.example.cs_module.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICoffeeShopRepository coffeeShopRepository;
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<OrderDetailDTO> findAll() {
        List<OrderDetail> orderDetailList = orderDetailRepository.listAllOrderInfo();
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        OrderDetailDTO orderDetailDTO;
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderDTO(new OrderDTO());
            orderDetailDTO.setCoffeeShopDTO(new CoffeeShopDTO());
            orderDetailDTO.setProductDTO(new ProductDTO());
//            orderDetailDTO.getProductDTO().setProductTypeDTO(new ProductTypeDTO());
            BeanUtils.copyProperties(orderDetail.getOrder(), orderDetailDTO.getOrderDTO());
            BeanUtils.copyProperties(orderDetail.getCoffeeShop(), orderDetailDTO.getCoffeeShopDTO());
            BeanUtils.copyProperties(orderDetail.getProduct(), orderDetailDTO.getProductDTO());
//            BeanUtils.copyProperties(orderDetail.getProduct().getProductType()
//                    , orderDetailDTO.getProductDTO().getProductTypeDTO());
            BeanUtils.copyProperties(orderDetail, orderDetailDTO);
            orderDetailDTOList.add(orderDetailDTO);
        }
        return orderDetailDTOList;
    }

    @Override
    public void createOrder(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(productService.findById(orderDetailDTO.getProductDTO().getId()));

        orderDetail.setCoffeeShop(coffeeShopRepository.findById(orderDetailDTO.getCoffeeShopDTO().getId()).get());

        orderDetail.setOrder(orderRepository.findById(orderDetailDTO.getOrderDTO().getId()).get());

        BeanUtils.copyProperties(orderDetailDTO, orderDetail);
        orderDetailRepository.save(orderDetail);
    }



    @Override
    public void deleteOrder(int id) {
        orderDetailRepository.delete(orderDetailRepository.findById(id).get());
    }

    @Override
    public void updateOrder(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailDTO.getId()).get();
        BeanUtils.copyProperties(orderDetailDTO, orderDetail);
        orderDetailRepository.save(orderDetail);
    }
}

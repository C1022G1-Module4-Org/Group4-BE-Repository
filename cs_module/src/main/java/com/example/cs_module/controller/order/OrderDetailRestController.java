package com.example.cs_module.controller.order;

import com.example.cs_module.dto.order.OrderDetailDTO;
import com.example.cs_module.service.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
@CrossOrigin("*")
public class OrderDetailRestController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    private List<OrderDetailDTO> showListOrderDetail () {
        return orderDetailService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    private void createOrder (@RequestBody OrderDetailDTO orderDetailDTO) {
        orderDetailService.createOrder(orderDetailDTO);
    }
}

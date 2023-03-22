package com.example.cs_module.dto.order;

import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.dto.product.ProductDTO;

public class OrderDetailDTO {
    private Integer id;
    private Integer quantity;
    private CoffeeShopDTO coffeeShopDTO;
    private ProductDTO productDTO;
    private OrderDTO orderDTO;
    private Integer totalMoney;

    public OrderDetailDTO() {
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CoffeeShopDTO getCoffeeShopDTO() {
        return coffeeShopDTO;
    }

    public void setCoffeeShopDTO(CoffeeShopDTO coffeeShopDTO) {
        this.coffeeShopDTO = coffeeShopDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
}

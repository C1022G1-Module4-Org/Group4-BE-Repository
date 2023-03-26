package com.example.cs_module.service.coffee_shop;

import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.model.coffee_shop.CoffeeShop;

import java.util.List;

public interface ICoffeeShopService {
    List<CoffeeShopDTO> findAll();
    CoffeeShop findById(int id);
}

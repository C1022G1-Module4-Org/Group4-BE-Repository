package com.example.cs_module.repository.coffee_shop;

import com.example.cs_module.model.coffee_shop.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoffeeShopRepository extends JpaRepository<CoffeeShop, Integer> {
}

package com.example.cs_module.controller.coffee_shop;

import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.service.coffee_shop.ICoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/coffe_shop")
public class CoffeeShopRestController {
    @Autowired
    private ICoffeeShopService coffeeShopService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CoffeeShopDTO>listAll(){
        return coffeeShopService.findAll();
    }

}

package com.example.cs_module.controller.product;

import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-for-customer")
@CrossOrigin("*")
public class ProductForCustomerRestController {
    @Autowired
    private IProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<ProductDTO> getList (@RequestParam(required = false, defaultValue = "") String name) {
        return productService.findByName(name);
    }
}

package com.example.cs_module.controller.product;

import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.service.product.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product-type")
public class ProductTypeRestController {
    @Autowired
    private IProductTypeService productTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<ProductTypeDTO> listAll () {
        return productTypeService.findAll();
    }
}

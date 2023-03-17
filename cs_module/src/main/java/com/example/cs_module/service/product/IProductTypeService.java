package com.example.cs_module.service.product;

import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.model.product.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductTypeDTO> findAll ();
    ProductType findById (int id);
}

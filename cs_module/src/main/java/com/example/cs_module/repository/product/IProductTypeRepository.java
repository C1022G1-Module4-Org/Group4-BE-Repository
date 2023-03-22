package com.example.cs_module.repository.product;

import com.example.cs_module.model.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    ProductType findById(int id);
}

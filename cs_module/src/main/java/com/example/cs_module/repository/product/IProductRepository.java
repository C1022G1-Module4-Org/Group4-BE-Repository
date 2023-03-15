package com.example.cs_module.repository.product;

import com.example.cs_be_module4.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}

package com.example.cs_module.repository.product;

import com.example.cs_module.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findProductsByNameContainingAndIsDeleted(Pageable pageable, String name, boolean isDeleted);
    List<Product> findByProductTypeName(String name);
}

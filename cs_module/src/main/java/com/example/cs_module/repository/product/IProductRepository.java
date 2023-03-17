package com.example.cs_module.repository.product;
import com.example.cs_module.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    Page<Product> findProductByNameContaining(Pageable pageable, String name);
//    Page<Product> findProductByNameOrProductTypeContaining(Pageable pageable, String name);
//    @Query(value = "select * from product p inner join product_type pt on p.product_type_id = pt.id" +
//            "where p.product_name like",
//            nativeQuery = true)
    Page<Product> findProductsByNameContainingAndIsDeleted(Pageable pageable, String name, boolean isDeleted);
}

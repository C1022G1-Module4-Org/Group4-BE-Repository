package com.example.cs_module.repository.customer;

import com.example.cs_module.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select c.* from `customer` c join `customer_type` ct on ct.customer_type_id = c.customer_type_id where c.customer_name like concat('%', :searchCustomerName, '%') and c.customer_email like concat('%', :searchCustomerEmail, '%') and ct.customer_type_name like concat('%', :searchCustomerTypeName, '%')", nativeQuery = true)
//    Page<Customer> searchCustomer(@Param("searchCustomerName") String searchCustomerName, @Param("searchCustomerEmail") String searchEmail, @Param("searchCustomerTypeName") String searchCustomerTypeName, Pageable pageable);

//    Page<Customer> findByCustomerNameContainingAndCustomerEmailContainingAndCustomerType_CustomerTypeName(String searchCustomerName, String searchCustomerEmail, String searchCustomerTypeName, Pageable pageable);
    Page<Customer> findByCustomerNameContaining(String searchCustomerName, Pageable pageable);
}

package com.example.cs_module.repository.customer;

import com.example.cs_module.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByCustomerNameContainingAndIsDeleteFalse(String searchCustomerName, Pageable pageable);
    Page<Customer> findByCustomerNameContainingAndIsDelete(String searchCustomerName, Pageable pageable, boolean isDelete);

    Customer findByCustomerId(int id);
}

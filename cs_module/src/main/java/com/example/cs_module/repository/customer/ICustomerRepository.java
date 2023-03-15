package com.example.cs_module.repository.customer;

import com.example.cs_be_module4.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

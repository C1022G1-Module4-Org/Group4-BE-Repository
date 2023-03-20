package com.example.cs_module.service.customer;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<CustomerDTO> searchCustomer(String searchCustomerName, Pageable pageable);

    List<Customer> findAllCustomer();

    void saveCustomer(Customer customer);

    Optional<Customer> findByIdCustomer(int id);

    void deleteCustomer(int id);
}

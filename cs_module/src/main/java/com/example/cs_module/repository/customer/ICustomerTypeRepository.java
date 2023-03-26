package com.example.cs_module.repository.customer;

import com.example.cs_module.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    Page<CustomerType> findByNameContaining( String searchCustomerTypeName,Pageable pageable);

    CustomerType findById(int id);
}

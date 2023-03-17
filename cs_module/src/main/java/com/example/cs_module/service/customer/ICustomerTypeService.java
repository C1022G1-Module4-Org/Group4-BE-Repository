package com.example.cs_module.service.customer;

import com.example.cs_module.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();
}

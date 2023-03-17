package com.example.cs_module.service.customer.impl;

import com.example.cs_module.model.customer.CustomerType;
import com.example.cs_module.repository.customer.ICustomerTypeRepository;
import com.example.cs_module.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}

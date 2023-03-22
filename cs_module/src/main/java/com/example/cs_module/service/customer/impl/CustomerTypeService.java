package com.example.cs_module.service.customer.impl;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.dto.customer.CustomerTypeDTO;
import com.example.cs_module.model.customer.Customer;
import com.example.cs_module.model.customer.CustomerType;
import com.example.cs_module.repository.customer.ICustomerTypeRepository;
import com.example.cs_module.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerTypeDTO> findAllCustomerType(String searchCustomerTypeName, Pageable pageable) {
        Page<CustomerType> customerTypePage = customerTypeRepository.findByNameContaining(searchCustomerTypeName, pageable);
        List<CustomerTypeDTO> customerTypeDTOList = new ArrayList<>();
        CustomerTypeDTO customerTypeDTO;
        for (CustomerType customerType : customerTypePage) {
            customerTypeDTO = new CustomerTypeDTO();
            Set<Customer> customerSet = customerType.getCustomerSet();
            Set<CustomerDTO> customerDTOSet = new HashSet<>();
            CustomerDTO customerDTO;
            for (Customer customer : customerSet) {
                customerDTO = new CustomerDTO();
                BeanUtils.copyProperties(customer, customerDTO);
                customerDTOSet.add(customerDTO);
            }
            customerTypeDTO.setCustomerSet(customerDTOSet);
            BeanUtils.copyProperties(customerType, customerTypeDTO);
            customerTypeDTOList.add(customerTypeDTO);
        }
        return new PageImpl<>(customerTypeDTOList, pageable, customerTypePage.getTotalElements());
    }

    @Override
    public CustomerTypeDTO findById(int id) {
        CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO();
        CustomerType customerType = customerTypeRepository.findById(id);
        Set<Customer> customerSet = customerType.getCustomerSet();
        Set<CustomerDTO> customerDTOSet = new HashSet<>();
        CustomerDTO customerDTO;
        for (Customer customer : customerSet) {
            customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOSet.add(customerDTO);
        }
        BeanUtils.copyProperties(customerType, customerTypeDTO);
        customerTypeDTO.setCustomerSet(customerDTOSet);
        return customerTypeDTO;
    }
}

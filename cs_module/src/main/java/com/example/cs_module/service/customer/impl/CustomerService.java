package com.example.cs_module.service.customer.impl;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.dto.customer.CustomerTypeDTO;
import com.example.cs_module.model.customer.Customer;
import com.example.cs_module.repository.customer.ICustomerRepository;
import com.example.cs_module.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

//    @Override
//    public Page<Customer> searchCustomer1(String searchCustomerName, String searchCustomerEmail, String searchCustomerTypeName, Pageable pageable) {
//        return customerRepository.findByCustomerNameContainingAndCustomerEmailContainingAndCustomerType_CustomerTypeName(searchCustomerName, searchCustomerEmail, searchCustomerTypeName, pageable);
//    }


    @Override
    public Page<CustomerDTO> searchCustomer(String customerName, Pageable pageable) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        Page<Customer> customerPage = customerRepository.findByCustomerNameContaining(customerName, pageable);
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
//            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return new PageImpl<>(customerDTOList);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByIdCustomer(int id) {
        return customerRepository.findById(id);
    }

//    @Override
//    public void deleteCustomer(int id) {
//        Optional<Customer> customer = customerRepository.findById(id);
//        customer.
//    }
}

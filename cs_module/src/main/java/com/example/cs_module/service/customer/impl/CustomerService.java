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

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<CustomerDTO> searchCustomer(String searchCustomerName, Pageable pageable) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        Page<Customer> customerPage = customerRepository
                .findByCustomerNameContainingAndIsDelete(searchCustomerName, pageable, false);
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return new PageImpl<>(customerDTOList, pageable, customerPage.getTotalElements());
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findByIdCustomer(int id) {
        return customerRepository.findById(id).get();
    }


    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findByCustomerId(id);
        customer.setDelete(true);
        customerRepository.save(customer);
    }
}

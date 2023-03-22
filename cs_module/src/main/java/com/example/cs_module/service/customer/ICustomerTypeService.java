package com.example.cs_module.service.customer;

import com.example.cs_module.dto.customer.CustomerTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService {
    Page<CustomerTypeDTO> findAllCustomerType(String searchCustomerTypeName , Pageable pageable);

    CustomerTypeDTO findById(int id);
}

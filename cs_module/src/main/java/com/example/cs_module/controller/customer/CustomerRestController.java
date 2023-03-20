package com.example.cs_module.controller.customer;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.model.customer.Customer;
import com.example.cs_module.model.customer.CustomerType;
import com.example.cs_module.service.customer.ICustomerService;
import com.example.cs_module.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<CustomerDTO> getCustomer(@PageableDefault(size = 10) Pageable pageable,
                                         @RequestParam(required = false, defaultValue = "") String searchCustomerName) {
        return customerService.searchCustomer(searchCustomerName, pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("")
    public void deleteCustomer(@RequestParam(required = false) Integer id){
        customerService.deleteCustomer(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerType(new CustomerType(customerDTO.getCustomerTypeDTO().getCustomerTypeId()));
        BeanUtils.copyProperties(customerDTO.getCustomerTypeDTO(),customer.getCustomerType());
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.saveCustomer(customer);
    }
}


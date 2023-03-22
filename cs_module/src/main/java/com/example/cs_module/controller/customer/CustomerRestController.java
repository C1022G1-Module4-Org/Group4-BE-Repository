package com.example.cs_module.controller.customer;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.dto.customer.CustomerTypeDTO;
import com.example.cs_module.model.customer.Customer;
import com.example.cs_module.model.customer.CustomerType;
import com.example.cs_module.service.customer.ICustomerService;
import com.example.cs_module.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public Page<CustomerDTO> getCustomer(@PageableDefault(size = 5) Pageable pageable,
                                         @RequestParam(required = false, defaultValue = "") String searchCustomerName) {
        Sort sort = Sort.by("customerId").descending();
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return customerService.searchCustomer(searchCustomerName, sortedPageaBle);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("")
    public void deleteCustomer(@RequestParam(required = false) Integer id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            customer.setCustomerType(new CustomerType(customerDTO.getCustomerTypeDTO().getCustomerTypeId()));
            BeanUtils.copyProperties(customerDTO.getCustomerTypeDTO(), customer.getCustomerType());
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.saveCustomer(customer);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public CustomerDTO detailCustomer(@PathVariable int id) {
        Customer customer = customerService.findByIdCustomer(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
        BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    public ResponseEntity<?> updateCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Customer customer = new Customer();
            customer.setCustomerType(new CustomerType());
            BeanUtils.copyProperties(customerDTO.getCustomerTypeDTO(), customer.getCustomerType());
            BeanUtils.copyProperties(customerDTO, customer);

            customerService.updateCustomer(customer);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
}


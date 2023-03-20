package com.example.cs_module.controller.customer;

import com.example.cs_module.dto.customer.CustomerTypeDTO;
import com.example.cs_module.model.customer.CustomerType;
import com.example.cs_module.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer-type")
public class CustomerTypeRestController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerTypeDTO> listCustomerType(@PageableDefault(size = 3) Pageable pageable,
                                                  @RequestParam(required = false, defaultValue = "") String name) {
        return customerTypeService.findAllCustomerType(name, pageable);
    }
}

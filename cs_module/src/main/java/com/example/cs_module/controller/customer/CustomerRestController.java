package com.example.cs_module.controller.customer;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.model.customer.Customer;
import com.example.cs_module.service.customer.ICustomerService;
import com.example.cs_module.service.customer.ICustomerTypeService;
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

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("")
//    public Page<CustomerDTO> getCustomer(@PageableDefault(size = 3, page = 0) Pageable pageable,
//                                         @RequestParam(required = false, defaultValue = "") String searchCustomerName) {
//        return customerService.searchCustomer(searchCustomerName, pageable);
//    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customerList = customerService.findAllCustomer();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer customer){
//        customerService.saveCustomer(customer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
//        customerService.deleteCustomer(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}


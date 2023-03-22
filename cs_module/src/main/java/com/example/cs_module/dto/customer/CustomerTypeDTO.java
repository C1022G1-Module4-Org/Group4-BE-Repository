package com.example.cs_module.dto.customer;

import java.util.Set;

public class CustomerTypeDTO {
    private int id;
    private String name;
    Set<CustomerDTO> customerSet;

    public CustomerTypeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CustomerDTO> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<CustomerDTO> customerSet) {
        this.customerSet = customerSet;
    }
}

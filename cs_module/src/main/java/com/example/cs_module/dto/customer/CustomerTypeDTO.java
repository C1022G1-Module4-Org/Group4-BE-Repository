package com.example.cs_module.dto.customer;

import java.util.Set;

public class CustomerTypeDTO {
    private int customerTypeId;
    private String customerTypeName;
    Set<CustomerDTO> customerSet;

    public CustomerTypeDTO() {
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<CustomerDTO> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<CustomerDTO> customerSet) {
        this.customerSet = customerSet;
    }
}

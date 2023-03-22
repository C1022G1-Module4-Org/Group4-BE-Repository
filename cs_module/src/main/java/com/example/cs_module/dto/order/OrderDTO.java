package com.example.cs_module.dto.order;

import com.example.cs_module.dto.customer.CustomerDTO;
import com.example.cs_module.dto.employee.CreateDTO;
import com.example.cs_module.dto.employee.EmployeeDTO;

import java.util.Set;

public class OrderDTO {
    private Integer id;
    private CreateDTO createDTO;
    private EmployeeDTO employeeDTO;
    private Set<OrderDetailDTO> orderDetailDTOSet;

    public OrderDTO() {
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CreateDTO getCreateDTO() {
        return createDTO;
    }

    public void setCreateDTO(CreateDTO createDTO) {
        this.createDTO = createDTO;
    }

    public Set<OrderDetailDTO> getOrderDetailDTOSet() {
        return orderDetailDTOSet;
    }

    public void setOrderDetailDTOSet(Set<OrderDetailDTO> orderDetailDTOSet) {
        this.orderDetailDTOSet = orderDetailDTOSet;
    }
}

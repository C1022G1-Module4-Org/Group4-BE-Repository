package com.example.cs_module.dto.employee;

import java.util.Set;

public class PositionDTO {
    private Integer id;
    private String position;
    private Set<EmployeeDTO> employeeSet;

    public PositionDTO() {
    }

    public PositionDTO(Integer id, String position, Set<EmployeeDTO> employeeSet) {
        this.id = id;
        this.position = position;
        this.employeeSet = employeeSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;
    }
}

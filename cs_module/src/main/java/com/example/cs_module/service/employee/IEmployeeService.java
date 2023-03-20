package com.example.cs_module.service.employee;

import com.example.cs_module.dto.employee.CreateDTO;
import com.example.cs_module.dto.employee.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeDTO> findAllByNameContaining(Pageable pageable, String search);

    void create(CreateDTO createDTO);

    void edit(EmployeeDTO employeeDTO);

    void delete(EmployeeDTO employeeDTO);

    EmployeeDTO findById(int id);
}

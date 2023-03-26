package com.example.cs_module.service.employee;

import com.example.cs_module.dto.employee.CreateDTO;
import com.example.cs_module.dto.employee.EmployeeDTO;
import com.example.cs_module.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeDTO> findAllByNameContaining(Pageable pageable, String search);

    void create(CreateDTO createDTO);

    void edit(CreateDTO createDTO, int id);

    void delete(EmployeeDTO employeeDTO);

    EmployeeDTO findById(int id);
    Employee findEmployeeById(int id);
}

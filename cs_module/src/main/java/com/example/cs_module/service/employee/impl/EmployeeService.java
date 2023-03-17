package com.example.cs_module.service.employee.impl;

import com.example.cs_module.dto.employee.EmployeeDTO;
import com.example.cs_module.dto.employee.PositionDTO;
import com.example.cs_module.model.employee.Employee;
import com.example.cs_module.repository.employee.IEmployeeRepository;
import com.example.cs_module.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeDTO> findAllByNameContaining(Pageable pageable, String search) {
        Page<Employee> employees = employeeRepository.findAllByNameContaining(pageable, search);
        List<EmployeeDTO> list = new ArrayList<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employees) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setPositionDTO(new PositionDTO());
            BeanUtils.copyProperties(employee.getPosition(), employeeDTO.getPositionDTO());
            BeanUtils.copyProperties(employee, employeeDTO);
            list.add(employeeDTO);
        }
        return new PageImpl<>(list, pageable, employees.getTotalElements()  );
    }

//    @Override
//    public void create(EmployeeDTO employeeDTO) {
//        employeeRepository.save(employeeDTO);
//    }
//
//    @Override
//    public void edit(EmployeeDTO employeeDTO) {
//        employeeRepository.save(employeeDTO);
//    }
//
//    @Override
//    public void delete(EmployeeDTO employeeDTO) {
//        employeeRepository.delete(employeeDTO);
//    }
//
//    @Override
//    public EmployeeDTO findById(int id) {
//        return null;
//    }
}

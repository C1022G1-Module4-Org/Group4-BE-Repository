package com.example.cs_module.service.employee.impl;

import com.example.cs_module.dto.employee.EmployeeDTO;
import com.example.cs_module.dto.employee.PositionDTO;
import com.example.cs_module.model.employee.Employee;
import com.example.cs_module.model.employee.Position;
import com.example.cs_module.repository.employee.IPositionRepository;
import com.example.cs_module.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    public void setValueOfEmployeeDTOSet(Position position, PositionDTO positionDTO) {
        Set<Employee> employeeSet = position.getEmployeeSet();
        Set<EmployeeDTO> employeeDTOSet = new LinkedHashSet<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employeeSet) {
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOSet.add(employeeDTO);
        }
        BeanUtils.copyProperties(position, positionDTO);
        positionDTO.setEmployeeSet(employeeDTOSet);
    }

    @Override
    public List<PositionDTO> findAll() {
        List<Position> positionList = positionRepository.findAll();
        List<PositionDTO> positionDTOList = new ArrayList<>();
        PositionDTO positionDTO;
        for (Position position : positionList) {
            positionDTO = new PositionDTO();
            setValueOfEmployeeDTOSet(position, positionDTO);
            BeanUtils.copyProperties(position, positionDTO);
            positionDTOList.add(positionDTO);
        }
        return positionDTOList;
    }
}

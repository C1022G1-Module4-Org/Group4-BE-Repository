package com.example.cs_module.service.employee;

import com.example.cs_module.dto.employee.PositionDTO;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll ();
}

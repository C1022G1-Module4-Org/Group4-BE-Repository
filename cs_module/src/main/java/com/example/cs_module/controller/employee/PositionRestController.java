package com.example.cs_module.controller.employee;

import com.example.cs_module.dto.employee.PositionDTO;
import com.example.cs_module.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@CrossOrigin("*")
public class PositionRestController {
    @Autowired
    private IPositionService positionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<PositionDTO> list() {
        return positionService.findAll();
    }
}

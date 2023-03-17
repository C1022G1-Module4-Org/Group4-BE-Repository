package com.example.cs_module.controller.employee;

import com.example.cs_module.dto.employee.EmployeeDTO;
import com.example.cs_module.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> listEmployee(@RequestParam(required = false, defaultValue = "") String search,
                                          @PageableDefault(size = 3) Pageable pageable) {
        return employeeService.findAllByNameContaining(pageable, search);
    }
}

package com.example.cs_module.controller.employee;

import com.example.cs_module.dto.employee.CreateDTO;
import com.example.cs_module.dto.employee.EmployeeDTO;
import com.example.cs_module.dto.employee.PositionDTO;
import com.example.cs_module.model.employee.Employee;
import com.example.cs_module.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public Page<EmployeeDTO> listEmployee(@RequestParam(required = false, defaultValue = "") String search,
                                          @PageableDefault(size = 5) Pageable pageable) {
        return employeeService.findAllByNameContaining(pageable, search);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(employeeService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody CreateDTO createDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            employeeService.create(createDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@Validated @RequestBody CreateDTO createDTO, BindingResult bindingResult, @PathVariable int id) {
        if (!bindingResult.hasErrors()) {
            employeeService.edit(createDTO, id);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/info/{id}")
    public CreateDTO showInfoEmployee(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id);
        CreateDTO createDTO = new CreateDTO();
        createDTO.setPositionDTO(new PositionDTO());
        BeanUtils.copyProperties(employee.getPosition(), createDTO.getPositionDTO());
        BeanUtils.copyProperties(employee, createDTO);
        return createDTO;
    }
}

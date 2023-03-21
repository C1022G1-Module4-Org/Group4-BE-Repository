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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> listEmployee(@RequestParam(required = false, defaultValue = "") String search,
                                          @PageableDefault(size = 5) Pageable pageable) {
        return employeeService.findAllByNameContaining(pageable, search);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.delete(employeeService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody CreateDTO createDTO) {
        employeeService.create(createDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    public void edit(@RequestBody CreateDTO createDTO, @PathVariable int id, @Valid BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            employeeService.edit(createDTO, id);
        }
    }

    @ResponseStatus(HttpStatus.OK)
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

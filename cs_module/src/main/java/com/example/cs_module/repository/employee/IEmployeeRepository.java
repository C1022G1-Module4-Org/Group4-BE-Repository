package com.example.cs_module.repository.employee;


import com.example.cs_module.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByNameContaining(Pageable pageable, String search);

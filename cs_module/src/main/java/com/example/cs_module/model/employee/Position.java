package com.example.cs_module.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue
    private Integer id;
    private String position;
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Employee> employeeSet;

    public Position() {
    }

    public Position(Integer id, String position, Set<Employee> employeeSet) {
        this.id = id;
        this.position = position;
        this.employeeSet = employeeSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}

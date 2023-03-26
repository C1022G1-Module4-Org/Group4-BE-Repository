package com.example.cs_module.dto.employee;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private PositionDTO positionDTO;
    private boolean gender;
    private String email;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, PositionDTO positionDTO, boolean gender, String email) {
        this.id = id;
        this.name = name;
        this.positionDTO = positionDTO;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

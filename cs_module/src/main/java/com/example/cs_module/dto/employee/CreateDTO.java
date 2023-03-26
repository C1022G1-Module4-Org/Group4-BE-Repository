package com.example.cs_module.dto.employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CreateDTO {
    private Integer id;
    @NotBlank(message = "{name.notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{name.pattern}")
    private String name;
    private PositionDTO positionDTO;
    private String dateOfBirth;
    private boolean gender;
    @NotBlank(message = "{name.notBlank}")
    @Email(message = "Định dạng email sai. Phải theo dạng abc123@gmail.com")
    private String email;
    @NotBlank(message = "{name.notBlank}")
    private String address;
    @NotBlank(message = "{name.notBlank}")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$", message = "Số điện thoại phải theo dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;
    private Set<EmployeeDTO> employeeSet;

    public CreateDTO() {
    }

    public CreateDTO(Integer id, String name, PositionDTO positionDTO, String dateOfBirth, boolean gender, String email, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.positionDTO = positionDTO;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;
    }
}

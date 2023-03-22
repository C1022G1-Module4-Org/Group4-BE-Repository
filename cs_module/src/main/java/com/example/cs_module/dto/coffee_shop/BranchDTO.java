package com.example.cs_module.dto.coffee_shop;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BranchDTO {
    private Integer id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "Không được chứa ký tự đặc biệt")
    private String name;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^[\\w.]+@[\\w&&[^_]]+([.][\\w&&[^_]]+){1,2}$", message = "Phải theo format abc@gmail.com")
    private String email;
    @NotBlank (message = "không được để trống phải điền số đt vào")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$", message = "Bạn phải nhập đúng số điện thoại miền Việt Nam")
    private String phone;
    @NotBlank(message = "không được để trống")
    private String address;
    private CoffeeShopDTO coffeeShopDTO;

    public BranchDTO() {
    }

    public BranchDTO(Integer id, String name, String email, String phone, String address, CoffeeShopDTO coffeeShopDTO) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.coffeeShopDTO = coffeeShopDTO;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CoffeeShopDTO getCoffeeShopDTO() {
        return coffeeShopDTO;
    }

    public void setCoffeeShopDTO(CoffeeShopDTO coffeeShopDTO) {
        this.coffeeShopDTO = coffeeShopDTO;
    }
}

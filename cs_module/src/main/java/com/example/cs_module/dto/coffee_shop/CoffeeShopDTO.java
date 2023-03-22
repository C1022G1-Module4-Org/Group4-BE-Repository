package com.example.cs_module.dto.coffee_shop;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CoffeeShopDTO {
    private Integer id;
    @NotBlank (message = "không được để trống")
    private String name;
    private Set<BranchDTO>branchDtoSet;

    public CoffeeShopDTO() {
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

    public Set<BranchDTO> getBranchDtoSet(Set<BranchDTO> branchDtoSet) {
        return this.branchDtoSet;
    }

    public void setBranchDtoSet(Set<BranchDTO> branchDtoSet) {
        this.branchDtoSet = branchDtoSet;
    }

    public CoffeeShopDTO(Integer id, String name, Set<BranchDTO> branchDtoSet) {
        this.id = id;
        this.name = name;
        this.branchDtoSet = branchDtoSet;
    }
}

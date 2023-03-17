package com.example.cs_module.model.coffee_shop;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CoffeeShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "coffeeShop")
    private Set<Branch>branchSet;

    public CoffeeShop() {
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

    public Set<Branch> getBranchSet() {
        return branchSet;
    }

    public void setBranchSet(Set<Branch> branchSet) {
        this.branchSet = branchSet;
    }
}

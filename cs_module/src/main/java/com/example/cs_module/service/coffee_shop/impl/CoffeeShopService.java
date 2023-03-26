package com.example.cs_module.service.coffee_shop.impl;


import com.example.cs_module.dto.coffee_shop.BranchDTO;
import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.model.coffee_shop.Branch;
import com.example.cs_module.model.coffee_shop.CoffeeShop;
import com.example.cs_module.repository.coffee_shop.ICoffeeShopRepository;
import com.example.cs_module.service.coffee_shop.ICoffeeShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CoffeeShopService implements ICoffeeShopService {
    @Autowired
    private ICoffeeShopRepository coffeeShopRepository;

    public void setValueOfBranchDtoSet(CoffeeShop coffeeShop,CoffeeShopDTO coffeeShopDTO){
        Set<Branch> branchSet=coffeeShop.getBranchSet();
        Set<BranchDTO>branchDtoSet=new LinkedHashSet<>();
        BranchDTO branchDto;
        for (Branch branch: branchSet){
            branchDto=new BranchDTO();
            BeanUtils.copyProperties(branch,branchDto);
            branchDtoSet.add(branchDto);
        }
        BeanUtils.copyProperties(coffeeShop,coffeeShopDTO);
        coffeeShopDTO.getBranchDtoSet(branchDtoSet);
    }

    @Override
    public List<CoffeeShopDTO> findAll() {
       List<CoffeeShop> coffeeShopList=coffeeShopRepository.findAll();
       List<CoffeeShopDTO>coffeeShopDTOList=new ArrayList<>();
       CoffeeShopDTO coffeeShopDTO;
       for (CoffeeShop coffeeShop:coffeeShopList){
           coffeeShopDTO=new CoffeeShopDTO();
           setValueOfBranchDtoSet(coffeeShop,coffeeShopDTO);
           BeanUtils.copyProperties(coffeeShop,coffeeShopDTO);
           coffeeShopDTOList.add(coffeeShopDTO);
       }
       return coffeeShopDTOList;
    }

    @Override
    public CoffeeShop findById(int id) {
        return coffeeShopRepository.findById(id);
    }
}

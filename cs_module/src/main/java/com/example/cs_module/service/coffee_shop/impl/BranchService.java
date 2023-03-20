package com.example.cs_module.service.coffee_shop.impl;

import com.example.cs_module.dto.coffee_shop.BranchDTO;
import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.model.coffee_shop.Branch;
import com.example.cs_module.model.coffee_shop.CoffeeShop;
import com.example.cs_module.repository.coffee_shop.IBranchRepository;
import com.example.cs_module.repository.coffee_shop.ICoffeeShopRepository;
import com.example.cs_module.service.coffee_shop.IBranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepository branchRepository;
    @Autowired
    private ICoffeeShopRepository coffeeShopRepository;

    @Override
    public Page<BranchDTO> findAllBranch(Pageable pageable, String name) {
        Page<Branch>branchPage=branchRepository.findBranchByNameContainingAndIsDelete(pageable,name,false);
        List<BranchDTO> branchDTOList=new ArrayList<>();
        BranchDTO branchDTO;
        for (Branch branch:branchPage){
            branchDTO = new BranchDTO();
            branchDTO.setCoffeeShopDTO(new CoffeeShopDTO());
            BeanUtils.copyProperties(branch.getCoffeeShop(),branchDTO.getCoffeeShopDTO());
//            branchDTO.setId(branch.getId());
            BeanUtils.copyProperties(branch,branchDTO);
            branchDTOList.add(branchDTO);
        }
        return new PageImpl<>(branchDTOList,pageable,branchPage.getTotalElements());
    }

    @Override
    public void create(BranchDTO branchDTO) {
        Branch branch=new Branch();
        branch.setCoffeeShop(coffeeShopRepository.findById(branchDTO.getCoffeeShopDTO().getId()).get());
        BeanUtils.copyProperties(branchDTO, branch);
        branchRepository.save(branch);
    }

    @Override
    public void delete(int id) {
        Branch branch=findById(id);
        branch.setDelete(true);
        branchRepository.save(branch);
    }

    @Override
    public Branch findById(int id) {
        return branchRepository.findById(id).get();
    }

    @Override
    public void update(BranchDTO branchDTO, int id) {
        Branch branch = branchRepository.findById(id).get();
        branch.setCoffeeShop(new CoffeeShop());
        BeanUtils.copyProperties(branchDTO.getCoffeeShopDTO(), branch.getCoffeeShop());
        BeanUtils.copyProperties(branchDTO, branch);
        branchRepository.save(branch);

    }

    @Override
    public List<BranchDTO> findByName(String name) {
        List<Branch> branchList = branchRepository.findCoffeShopName(name);
        List<BranchDTO> productDTOList = new ArrayList<>();
        BranchDTO branchDTO;
        for (Branch branch : branchList) {
            branchDTO = new BranchDTO();
            branchDTO.setCoffeeShopDTO(new CoffeeShopDTO());
            BeanUtils.copyProperties(branch.getCoffeeShop(), branchDTO.getCoffeeShopDTO());
            BeanUtils.copyProperties(branch, branchDTO);
            productDTOList.add(branchDTO);
        }
        return productDTOList;
    }
    }




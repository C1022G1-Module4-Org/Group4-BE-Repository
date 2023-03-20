package com.example.cs_module.service.coffee_shop;

import com.example.cs_module.dto.coffee_shop.BranchDTO;
import com.example.cs_module.model.coffee_shop.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBranchService {
    Page<BranchDTO>findAllBranch(Pageable pageable,String name);
    void  create(BranchDTO branchDTO);
    void  delete(int id);
    Branch findById(int id);
    void update(BranchDTO branchDTO,int id);
    List<BranchDTO> findByName(String name);
}

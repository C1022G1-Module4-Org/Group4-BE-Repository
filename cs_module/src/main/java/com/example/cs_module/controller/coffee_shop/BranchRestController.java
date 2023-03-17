package com.example.cs_module.controller.coffee_shop;

import com.example.cs_module.dto.coffee_shop.BranchDTO;
import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.service.coffee_shop.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/branch")
public class BranchRestController {
    @Autowired
    private IBranchService branchService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BranchDTO> getBranchList(@Valid @PageableDefault(size = 3) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return branchService.findAllBranch(sortedPageaBle, name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) {
        branchService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody BranchDTO branchDTO) {
        branchService.create(branchDTO);
    }

}

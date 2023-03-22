package com.example.cs_module.controller.coffee_shop;

import com.example.cs_module.dto.coffee_shop.BranchDTO;
import com.example.cs_module.dto.coffee_shop.CoffeeShopDTO;
import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.model.coffee_shop.Branch;
import com.example.cs_module.service.coffee_shop.IBranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/branch")
public class BranchRestController {
    @Autowired
    private IBranchService branchService;

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public Page<BranchDTO> getBranchList(@Valid @PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return branchService.findAllBranch(sortedPageaBle, name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) {
        branchService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody BranchDTO branchDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            branchService.create(branchDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,  HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public BranchDTO showBranchDetail(@PathVariable int id){
        Branch branch = branchService.findById(id);
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setCoffeeShopDTO(new CoffeeShopDTO());
        BeanUtils.copyProperties(branch.getCoffeeShop(), branchDTO.getCoffeeShopDTO());
        BeanUtils.copyProperties(branch, branchDTO);
        return branchDTO;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@Validated @RequestBody BranchDTO branchDTO, BindingResult bindingResult,
                            @PathVariable int id
                            ) {

        if (!bindingResult.hasErrors()) {
            branchService.update(branchDTO, id);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,  HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

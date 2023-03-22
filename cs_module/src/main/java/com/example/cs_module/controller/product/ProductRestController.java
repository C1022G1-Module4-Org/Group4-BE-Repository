package com.example.cs_module.controller.product;

import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.model.product.Product;
import com.example.cs_module.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService productService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<ProductDTO> getProductList (@Valid
                                            @PageableDefault(size = 3)Pageable pageable,
                                            @RequestParam(required = false, defaultValue = "") String name) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return productService.findALLProduct(sortedPageable, name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable int id) {
        productService.delete(id);
    }

//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> create (@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            productService.create(productDTO);
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
    @GetMapping("/detail/{id}")
    public ProductDTO showProductDetail (@PathVariable int id) {
        Product product = productService.findById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductTypeDTO(new ProductTypeDTO());
        BeanUtils.copyProperties(product.getProductType(), productDTO.getProductTypeDTO());
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult,@PathVariable int id
                                         ) {
        if (!bindingResult.hasErrors()) {
            productService.update(productDTO, id);
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

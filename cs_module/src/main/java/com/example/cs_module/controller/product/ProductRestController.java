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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create (@RequestBody ProductDTO productDTO, @Valid BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            productService.create(productDTO);
        }
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

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    public void editProduct(@RequestBody ProductDTO productDTO, @PathVariable int id, @Valid BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            productService.update(productDTO, id);
        }
    }
}

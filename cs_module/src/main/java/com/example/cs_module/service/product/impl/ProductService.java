package com.example.cs_module.service.product.impl;

import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.model.product.Product;
import com.example.cs_module.model.product.ProductType;
import com.example.cs_module.repository.product.IProductRepository;
import com.example.cs_module.repository.product.IProductTypeRepository;
import com.example.cs_module.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public Page<ProductDTO> findALLProduct(Pageable pageable, String name) {
        Page<Product> productPage = productRepository
                .findProductsByNameContainingAndIsDeleted(pageable, name, false);
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productPage) {
            productDTO = new ProductDTO();
            productDTO.setProductTypeDTO(new ProductTypeDTO());
            BeanUtils.copyProperties(product.getProductType(), productDTO.getProductTypeDTO());
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return new PageImpl<>(productDTOList, pageable, productPage.getTotalElements());
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductType(productTypeRepository.findById(productDTO.getProductTypeDTO().getId()).get());
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        product.setDeleted(true);
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void update(ProductDTO productDTO, int id) {
        Product product = productRepository.findById(id).get();
        product.setProductType(new ProductType());
        BeanUtils.copyProperties(productDTO.getProductTypeDTO(), product.getProductType());
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        List<Product> productList = productRepository.findByProductTypeName(name);
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productList) {
            productDTO = new ProductDTO();
            productDTO.setProductTypeDTO(new ProductTypeDTO());
            BeanUtils.copyProperties(product.getProductType(), productDTO.getProductTypeDTO());
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}

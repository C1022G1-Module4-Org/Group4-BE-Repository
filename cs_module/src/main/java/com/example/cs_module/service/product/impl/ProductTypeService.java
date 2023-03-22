package com.example.cs_module.service.product.impl;

import com.example.cs_module.dto.product.ProductDTO;
import com.example.cs_module.dto.product.ProductTypeDTO;
import com.example.cs_module.model.product.Product;
import com.example.cs_module.model.product.ProductType;
import com.example.cs_module.repository.product.IProductTypeRepository;
import com.example.cs_module.service.product.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    public void setValueOfProductDTOSet (ProductType productType, ProductTypeDTO productTypeDTO) {
        Set<Product> productSet = productType.getProductSet();
        Set<ProductDTO> productDTOSet = new LinkedHashSet<>();
        ProductDTO productDTO;
        for (Product product : productSet) {
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOSet.add(productDTO);
        }
        BeanUtils.copyProperties(productType, productTypeDTO);
        productTypeDTO.setProductDTOSet(productDTOSet);
    }

    @Override
    public List<ProductTypeDTO> findAll() {
        List<ProductType> productTypeList = productTypeRepository.findAll();
        List<ProductTypeDTO> productTypeDTOList = new ArrayList<>();
        ProductTypeDTO productTypeDTO;
        for (ProductType productType : productTypeList) {
            productTypeDTO = new ProductTypeDTO();
            setValueOfProductDTOSet(productType, productTypeDTO);
            BeanUtils.copyProperties(productType, productTypeDTO);
            productTypeDTOList.add(productTypeDTO);
        }
        return productTypeDTOList;
    }

    @Override
    public ProductType findById(int id) {
        return productTypeRepository.findById(id);
    }
}

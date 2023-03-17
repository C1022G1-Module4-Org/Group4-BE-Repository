package com.example.cs_module.dto.product;

import com.example.cs_module.model.product.ProductType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Arrays;

public class ProductDTO  {
    private Integer id;
    @NotBlank(message = "{name.notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{name.pattern}")
    private String name;
    @NotBlank(message = "{price.notBlank}")
    private Double price;
    @NotBlank(message = "{imgURL.notBlank}")
    private String imgURL;
    private ProductTypeDTO productTypeDTO;

    public ProductDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public ProductTypeDTO getProductTypeDTO() {
        return productTypeDTO;
    }

    public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
        this.productTypeDTO = productTypeDTO;
    }

}

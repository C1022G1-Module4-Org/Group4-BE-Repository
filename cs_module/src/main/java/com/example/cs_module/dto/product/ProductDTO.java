package com.example.cs_module.dto.product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ProductDTO {
    private Integer id;
    @NotBlank(message = "{name.notBlank}")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{name.pattern}")
    private String name;
    @Min(value = 0, message = "Giá bán phải lớn hơn 0")
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

package com.web.shop.dto.Products;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @NotBlank
    @Digits(integer = 10, fraction = 2)
    private Double price;

    private ProductsCategoryDTO productsCategory;

    @Size(min = 1, max = 10)
    @NotBlank
    private Integer stockQuantity;

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

    public ProductsCategoryDTO getProductsCategory() {
        return productsCategory;
    }

    public void setProductsCategory(ProductsCategoryDTO productsCategoryDTO) {
        this.productsCategory = productsCategoryDTO;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productsCategory=" + productsCategory +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}

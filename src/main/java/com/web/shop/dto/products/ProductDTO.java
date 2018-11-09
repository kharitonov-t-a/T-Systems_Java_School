package com.web.shop.dto.products;

import com.web.shop.model.products.ProductCharacteristic;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

    public ProductDTO(Integer id) {
        this.id = id;
    }
    public ProductDTO() {
    }
    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Digits(integer = 10, fraction = 2)
    private Double price;

    private ProductsCategoryDTO productsCategory;
    private Integer productsCategoryId;

    @Digits(integer = 10, fraction = 0)
    private Integer stockQuantity;

    private List<ProductCharacteristicDTO> productCharacteristic;

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

    public Integer getProductsCategoryId() {
        return productsCategoryId;
    }

    public void setProductsCategoryId(Integer productsCategoryId) {
        this.productsCategoryId = productsCategoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productsCategory=" + productsCategory +
                ", productsCategoryId=" + productsCategoryId +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    public List<ProductCharacteristicDTO> getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristicDTO> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }
}

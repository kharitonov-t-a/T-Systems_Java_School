package com.web.shop.dto.product;

import com.web.shop.dto.order.OrderProductDTO;
import com.web.shop.model.enums.Sorting;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO implements Serializable {

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Size(min = 3, max = 30)
    @NotBlank
    private String characterCode;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    private BigDecimal priceFilterMin;
    private BigDecimal priceFilterMax;
    private Sorting sort = Sorting.ASC_NAME;

    @Digits(integer = 10, fraction = 0)
    private Integer stockQuantity;

    private ProductCategoryDTO productCategory;

    private List<ProductCharacteristicDTO> productCharacteristicList = new ArrayList<>();

    private List<OrderProductDTO> orderProductList = new ArrayList<>();

    private Integer countSlaveCharacteristics;

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

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCharacteristicDTO> getProductCharacteristicList() {
        return productCharacteristicList;
    }

    public void setProductCharacteristicList(List<ProductCharacteristicDTO> productCharacteristicList) {
        this.productCharacteristicList = productCharacteristicList;
    }

    public List<OrderProductDTO> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProductDTO> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public BigDecimal getPriceFilterMin() {
        return priceFilterMin;
    }

    public void setPriceFilterMin(BigDecimal priceFilterMin) {
        this.priceFilterMin = priceFilterMin;
    }

    public BigDecimal getPriceFilterMax() {
        return priceFilterMax;
    }

    public void setPriceFilterMax(BigDecimal priceFilterMax) {
        this.priceFilterMax = priceFilterMax;
    }

    public Sorting getSort() {
        return sort;
    }

    public void setSort(Sorting sort) {
        this.sort = sort;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characterCode='" + characterCode + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    public Integer getCountSlaveCharacteristics() {
        return countSlaveCharacteristics;
    }

    public void setCountSlaveCharacteristics(Integer countSlaveCharacteristics) {
        this.countSlaveCharacteristics = countSlaveCharacteristics;
    }
}

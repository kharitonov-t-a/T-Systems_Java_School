package com.web.shop.dto.product;

import com.web.shop.dto.order.OrderProductDTO;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
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

    private ProductCategoryDTO productCategory;

    @Digits(integer = 10, fraction = 0)
    private Integer stockQuantity;

    private List<ProductCharacteristicDTO> productCharacteristicList;

    private List<OrderProductDTO> orderProductList;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategoryDTO) {
        this.productCategory = productCategoryDTO;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
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

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

//    @Override
//    public String toString() {
//        return "ProductDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", productCategory=" + productCategory +
//                ", stockQuantity=" + stockQuantity +
//                ", productCharacteristicList=" + productCharacteristicList +
//                ", orderProductList=" + orderProductList +
//                '}';
//    }
}

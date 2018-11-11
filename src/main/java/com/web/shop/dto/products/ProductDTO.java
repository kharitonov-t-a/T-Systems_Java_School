package com.web.shop.dto.products;

import com.web.shop.dto.orders.OrderProductDTO;
import com.web.shop.model.orders.OrderProduct;
import com.web.shop.model.products.ProductCharacteristic;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Digits(integer = 10, fraction = 2)
    private Double price;

    private ProductsCategoryDTO productsCategory;

    @Digits(integer = 10, fraction = 0)
    private Integer stockQuantity;

    private List<ProductCharacteristicDTO> productCharacteristic;

    private List<OrderProductDTO> orderProducts;

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


    public List<ProductCharacteristicDTO> getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristicDTO> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    @Override
//    public String toString() {
//        return "ProductDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", productsCategory=" + productsCategory +
//                ", stockQuantity=" + stockQuantity +
//                ", productCharacteristic=" + productCharacteristic +
//                ", orderProducts=" + orderProducts +
//                '}';
//    }
}

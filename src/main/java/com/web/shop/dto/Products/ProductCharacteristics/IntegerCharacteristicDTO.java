package com.web.shop.dto.Products.ProductCharacteristics;

import com.web.shop.dto.Products.ProductCharacteristicDTO;
import com.web.shop.dto.Products.ProductDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class IntegerCharacteristicDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicDTO productCharacteristic;

    private ProductDTO product;

    @NotBlank
    private Integer value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicDTO getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(ProductCharacteristicDTO productCharacteristicDTO) {
        this.productCharacteristic = productCharacteristicDTO;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntegerCharacteristicDTO{" +
                "id=" + id +
                ", productCharacteristic=" + productCharacteristic +
                ", product=" + product +
                ", value=" + value +
                '}';
    }
}

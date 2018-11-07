package com.web.shop.dto.Products.ProductCharacteristics;

import com.web.shop.dto.Products.ProductCharacteristicDTO;
import com.web.shop.dto.Products.ProductDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CheckboxCharacteristicDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicDTO productCharacteristic;

    private ProductDTO product;

    @NotBlank
    private boolean value;

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

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CheckboxCharacteristicDTO{" +
                "id=" + id +
                ", productCharacteristic=" + productCharacteristic +
                ", product=" + product +
                ", value=" + value +
                '}';
    }
}

package com.web.shop.dto.product;

import com.web.shop.model.product.ProductCharacteristicCheckboxField;

import java.io.Serializable;

public class ProductCharacteristicCheckboxValueDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicCheckboxFieldDTO productCharacteristicCheckboxField;

    private ProductCharacteristicDTO productCharacteristic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicCheckboxFieldDTO getProductCharacteristicCheckboxField() {
        return productCharacteristicCheckboxField;
    }

    public void setProductCharacteristicCheckboxField(ProductCharacteristicCheckboxFieldDTO productCharacteristicCheckboxField) {
        this.productCharacteristicCheckboxField = productCharacteristicCheckboxField;
    }

    public ProductCharacteristicDTO getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(ProductCharacteristicDTO productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

//    @Override
//    public String toString() {
//        return "ProductCharacteristicCheckboxValueDTO{" +
//                "id=" + id +
//                ", value=" + value +
//                ", productCharacteristic=" + productCharacteristic +
//                '}';
//    }
}

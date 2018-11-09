package com.web.shop.dto.products;

import com.web.shop.model.products.ProductCharacteristic;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

public class CheckboxCharacteristicValuesDTO implements Serializable {


    public CheckboxCharacteristicValuesDTO(Integer value) {
        this.value = value;
    }

    public CheckboxCharacteristicValuesDTO() {
    }


    private Integer id;

    private Integer value;

    private ProductCharacteristicDTO productCharacteristic;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ProductCharacteristicDTO getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(ProductCharacteristicDTO productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    @Override
    public String toString() {
        return "CheckboxCharacteristicValues{" +
                "id=" + id +
                ", value=" + value +
                ", productCharacteristic=" + productCharacteristic +
                '}';
    }
}

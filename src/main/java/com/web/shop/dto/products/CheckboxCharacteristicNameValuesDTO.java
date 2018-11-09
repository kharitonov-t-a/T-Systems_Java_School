package com.web.shop.dto.products;

import com.web.shop.model.products.ProductCharacteristicType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

public class CheckboxCharacteristicNameValuesDTO implements Serializable {

    private Integer id;

    private String value;

    private ProductCharacteristicTypeDTO productCharacteristicType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductCharacteristicTypeDTO getProductCharacteristicType() {
        return productCharacteristicType;
    }

    public void setProductCharacteristicType(ProductCharacteristicTypeDTO productCharacteristicType) {
        this.productCharacteristicType = productCharacteristicType;
    }

    @Override
    public String toString() {
        return "CheckboxCharacteristicNameValues{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", productCharacteristicType=" + productCharacteristicType +
                '}';
    }
}

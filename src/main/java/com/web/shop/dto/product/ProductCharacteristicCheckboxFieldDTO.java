package com.web.shop.dto.product;

import java.io.Serializable;

public class ProductCharacteristicCheckboxFieldDTO implements Serializable {

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

//    @Override
//    public String toString() {
//        return "ProductCharacteristicCheckboxFieldDTO{" +
//                "id=" + id +
//                ", value='" + value + '\'' +
//                ", productCharacteristicType=" + productCharacteristicType +
//                '}';
//    }
}

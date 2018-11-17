package com.web.shop.dto.product;

import java.io.Serializable;
import java.util.List;

public class ProductCharacteristicDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicTypeDTO productCharacteristicType;

    private ProductDTO product;

    private List<ProductCharacteristicCheckboxValueDTO> productCharacteristicCheckboxValueList;

    private Boolean booleanCharacteristicValue;

    private Double doubleCharacteristicValue;

    private Integer integerCharacteristicValue;

    private String stringCharacteristicValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicTypeDTO getProductCharacteristicType() {
        return productCharacteristicType;
    }

    public void setProductCharacteristicType(ProductCharacteristicTypeDTO productCharacteristicType) {
        this.productCharacteristicType = productCharacteristicType;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public List<ProductCharacteristicCheckboxValueDTO> getProductCharacteristicCheckboxValueList() {
        return productCharacteristicCheckboxValueList;
    }

    public void setProductCharacteristicCheckboxValueList(List<ProductCharacteristicCheckboxValueDTO> productCharacteristicCheckboxValueList) {
        this.productCharacteristicCheckboxValueList = productCharacteristicCheckboxValueList;
    }

    public Boolean getBooleanCharacteristicValue() {
        return booleanCharacteristicValue;
    }

    public void setBooleanCharacteristicValue(Boolean booleanCharacteristicValue) {
        this.booleanCharacteristicValue = booleanCharacteristicValue;
    }

    public Double getDoubleCharacteristicValue() {
        return doubleCharacteristicValue;
    }

    public void setDoubleCharacteristicValue(Double doubleCharacteristicValue) {
        this.doubleCharacteristicValue = doubleCharacteristicValue;
    }

    public Integer getIntegerCharacteristicValue() {
        return integerCharacteristicValue;
    }

    public void setIntegerCharacteristicValue(Integer integerCharacteristicValue) {
        this.integerCharacteristicValue = integerCharacteristicValue;
    }

    public String getStringCharacteristicValue() {
        return stringCharacteristicValue;
    }

    public void setStringCharacteristicValue(String stringCharacteristicValue) {
        this.stringCharacteristicValue = stringCharacteristicValue;
    }

//    @Override
//    public String toString() {
//        return "ProductCharacteristicDTO{" +
//                "id=" + id +
//                ", productCharacteristicType=" + productCharacteristicType +
//                ", product=" + product +
//                ", productCharacteristicCheckboxValueList=" + productCharacteristicCheckboxValueList +
//                ", booleanCharacteristicValue=" + booleanCharacteristicValue +
//                ", doubleCharacteristicValue=" + doubleCharacteristicValue +
//                ", integerCharacteristicValue=" + integerCharacteristicValue +
//                ", stringCharacteristicValue='" + stringCharacteristicValue + '\'' +
//                '}';
//    }
}

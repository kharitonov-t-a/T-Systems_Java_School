package com.web.shop.dto.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductCharacteristicDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicTypeDTO productCharacteristicType;

    private ProductDTO product;

    private List<ProductCharacteristicCheckboxValueDTO> productCharacteristicCheckboxValueList  = new ArrayList<>();

    private Boolean booleanCharacteristicValue;

    private Double doubleCharacteristicValue;

    private Double doubleCharacteristicFilterMin;
    private Double doubleCharacteristicFilterMax;

    private Integer integerCharacteristicValue;

    private Integer integerCharacteristicFilterMin;
    private Integer integerCharacteristicFilterMax;

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

    public Double getDoubleCharacteristicFilterMin() {
        return doubleCharacteristicFilterMin;
    }

    public void setDoubleCharacteristicFilterMin(Double doubleCharacteristicFilterMin) {
        this.doubleCharacteristicFilterMin = doubleCharacteristicFilterMin;
    }

    public Double getDoubleCharacteristicFilterMax() {
        return doubleCharacteristicFilterMax;
    }

    public void setDoubleCharacteristicFilterMax(Double doubleCharacteristicFilterMax) {
        this.doubleCharacteristicFilterMax = doubleCharacteristicFilterMax;
    }

    public Integer getIntegerCharacteristicFilterMin() {
        return integerCharacteristicFilterMin;
    }

    public void setIntegerCharacteristicFilterMin(Integer integerCharacteristicFilterMin) {
        this.integerCharacteristicFilterMin = integerCharacteristicFilterMin;
    }

    public Integer getIntegerCharacteristicFilterMax() {
        return integerCharacteristicFilterMax;
    }

    public void setIntegerCharacteristicFilterMax(Integer integerCharacteristicFilterMax) {
        this.integerCharacteristicFilterMax = integerCharacteristicFilterMax;
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

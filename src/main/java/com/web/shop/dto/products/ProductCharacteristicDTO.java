package com.web.shop.dto.products;

import java.io.Serializable;
import java.util.List;

public class ProductCharacteristicDTO implements Serializable {

    private Integer id;

    private ProductCharacteristicTypeDTO productCharacteristicType;
    private Integer productCharacteristicTypeId;

    private ProductDTO product;
    private Integer productId;

    private List<CheckboxCharacteristicValuesDTO> checkboxCharacteristicValues;
    private List<Integer> checkboxCharacteristicValuesInteger;

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

    public List<CheckboxCharacteristicValuesDTO> getCheckboxCharacteristicValues() {
        return checkboxCharacteristicValues;
    }

    public void setCheckboxCharacteristicValues(List<CheckboxCharacteristicValuesDTO> checkboxCharacteristicValues) {
        this.checkboxCharacteristicValues = checkboxCharacteristicValues;
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

    @Override
    public String toString() {
        return "ProductCharacteristicDTO{" +
                "id=" + id +
                ", productCharacteristicType=" + productCharacteristicType +
                ", product=" + product +
                ", checkboxCharacteristicValues=" + checkboxCharacteristicValues +
                ", booleanCharacteristicValue=" + booleanCharacteristicValue +
                ", doubleCharacteristicValue=" + doubleCharacteristicValue +
                ", integerCharacteristicValue=" + integerCharacteristicValue +
                ", stringCharacteristicValue='" + stringCharacteristicValue + '\'' +
                '}';
    }

    public Integer getProductCharacteristicTypeId() {
        return productCharacteristicTypeId;
    }

    public void setProductCharacteristicTypeId(Integer productCharacteristicTypeId) {
        this.productCharacteristicTypeId = productCharacteristicTypeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Integer> getCheckboxCharacteristicValuesInteger() {
        return checkboxCharacteristicValuesInteger;
    }

    public void setCheckboxCharacteristicValuesInteger(List<Integer> checkboxCharacteristicValuesInteger) {
        this.checkboxCharacteristicValuesInteger = checkboxCharacteristicValuesInteger;
    }
}

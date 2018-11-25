package com.web.shop.model.product;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductCharacteristic")
public class ProductCharacteristic implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "productCharacteristicTypeId")
    private ProductCharacteristicType productCharacteristicType;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @OneToMany(mappedBy="productCharacteristic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristicCheckboxValue> productCharacteristicCheckboxValueList = new ArrayList<>();;

    @Column(name = "booleanCharacteristicValue")
    private Boolean booleanCharacteristicValue;

    @Column(name = "doubleCharacteristicValue")
    private Double doubleCharacteristicValue;

    @Column(name = "integerCharacteristicValue")
    private Integer integerCharacteristicValue;

    @Column(name = "stringCharacteristicValue")
    private String stringCharacteristicValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicType getProductCharacteristicType() {
        return productCharacteristicType;
    }

    public void setProductCharacteristicType(ProductCharacteristicType productCharacteristicType) {
        this.productCharacteristicType = productCharacteristicType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductCharacteristicCheckboxValue> getProductCharacteristicCheckboxValueList() {
        return productCharacteristicCheckboxValueList;
    }

    public void setProductCharacteristicCheckboxValueList(List<ProductCharacteristicCheckboxValue> productCharacteristicCheckboxValueList) {
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
//        return "ProductCharacteristic{" +
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

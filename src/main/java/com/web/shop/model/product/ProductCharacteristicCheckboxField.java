package com.web.shop.model.product;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductCharacteristicCheckboxField")
public class ProductCharacteristicCheckboxField implements Serializable {

    public ProductCharacteristicCheckboxField(){

    }

    public ProductCharacteristicCheckboxField(String value, ProductCharacteristicType productCharacteristicType){
        this.value = value;
        this.productCharacteristicType = productCharacteristicType;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name="productCharacteristicTypeId")
    private ProductCharacteristicType productCharacteristicType;

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

    public ProductCharacteristicType getProductCharacteristicType() {
        return productCharacteristicType;
    }

    public void setProductCharacteristicType(ProductCharacteristicType productCharacteristicType) {
        this.productCharacteristicType = productCharacteristicType;
    }

//    @Override
//    public String toString() {
//        return "ProductCharacteristicCheckboxField{" +
//                "id=" + id +
//                ", value='" + value + '\'' +
//                ", productCharacteristicType=" + productCharacteristicType +
//                '}';
//    }
}

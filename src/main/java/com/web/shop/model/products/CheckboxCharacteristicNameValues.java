package com.web.shop.model.products;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CheckboxCharacteristicNameValues")
public class CheckboxCharacteristicNameValues implements Serializable {

    CheckboxCharacteristicNameValues(){

    }

    public CheckboxCharacteristicNameValues(String value, ProductCharacteristicType productCharacteristicType){
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
//        return "CheckboxCharacteristicNameValues{" +
//                "id=" + id +
//                ", value='" + value + '\'' +
//                ", productCharacteristicType=" + productCharacteristicType +
//                '}';
//    }
}

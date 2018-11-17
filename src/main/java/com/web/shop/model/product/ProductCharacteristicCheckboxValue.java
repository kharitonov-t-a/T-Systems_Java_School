package com.web.shop.model.product;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductCharacteristicCheckboxValue")
public class ProductCharacteristicCheckboxValue implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name="productCharacteristicId", nullable=false)
    private ProductCharacteristic productCharacteristic;

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

    public ProductCharacteristic getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(ProductCharacteristic productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

//    @Override
//    public String toString() {
//        return "ProductCharacteristicCheckboxValue{" +
//                "id=" + id +
//                ", value=" + value +
//                ", productCharacteristic=" + productCharacteristic +
//                '}';
//    }
}

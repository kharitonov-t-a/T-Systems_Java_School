package com.web.shop.model.product;

import com.web.shop.dto.product.ProductCharacteristicCheckboxFieldDTO;
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

    @ManyToOne
    @JoinColumn(name="productCharacteristicCheckboxFieldId")
    private ProductCharacteristicCheckboxField productCharacteristicCheckboxField;

    @ManyToOne
    @JoinColumn(name="productCharacteristicId")
    private ProductCharacteristic productCharacteristic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicCheckboxField getProductCharacteristicCheckboxField() {
        return productCharacteristicCheckboxField;
    }

    public void setProductCharacteristicCheckboxField(ProductCharacteristicCheckboxField productCharacteristicCheckboxField) {
        this.productCharacteristicCheckboxField = productCharacteristicCheckboxField;
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

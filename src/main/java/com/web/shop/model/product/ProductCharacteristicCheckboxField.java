package com.web.shop.model.product;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductCharacteristicCheckboxField")
public class ProductCharacteristicCheckboxField implements Serializable {

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

    @OneToMany(mappedBy="productCharacteristicCheckboxField", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristicCheckboxValue> productCharacteristicCheckboxValueList = new ArrayList<>();

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

    public List<ProductCharacteristicCheckboxValue> getProductCharacteristicCheckboxValueList() {
        return productCharacteristicCheckboxValueList;
    }

    public void setProductCharacteristicCheckboxValueList(List<ProductCharacteristicCheckboxValue> productCharacteristicCheckboxValueList) {
        this.productCharacteristicCheckboxValueList = productCharacteristicCheckboxValueList;
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

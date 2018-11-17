package com.web.shop.model.product;

import com.web.shop.model.enums.CharacteristicType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductCharacteristicType")
public class ProductCharacteristicType implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "measure", length = 30)
    @Size(min = 1, max = 30)
    private String measure;

    @Column(name = "characteristicType")
    @Enumerated(EnumType.STRING)
    private CharacteristicType characteristicType;

    @OneToMany(mappedBy="productCharacteristicType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristicCheckboxField> productCharacteristicCheckboxFieldList;

    @OneToMany(mappedBy="productCharacteristicType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristic> productCharacteristicList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public com.web.shop.model.enums.CharacteristicType getCharacteristicType() {
        return characteristicType;
    }

    public void setCharacteristicType(com.web.shop.model.enums.CharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    public List<ProductCharacteristicCheckboxField> getProductCharacteristicCheckboxFieldList() {
        return productCharacteristicCheckboxFieldList;
    }
    public List<String> getCheckboxCharacteristicNameValuesToString() {
        List<String> listValues = new ArrayList<>();
        productCharacteristicCheckboxFieldList.forEach((i)->listValues.add(i.getValue()));
        return listValues;
    }

    public void setProductCharacteristicCheckboxFieldList(List<ProductCharacteristicCheckboxField> productCharacteristicCheckboxFieldList) {
        this.productCharacteristicCheckboxFieldList = productCharacteristicCheckboxFieldList;
    }

    public List<ProductCharacteristic> getProductCharacteristicList() {
        return productCharacteristicList;
    }

    public void setProductCharacteristicList(List<ProductCharacteristic> productCharacteristicList) {
        this.productCharacteristicList = productCharacteristicList;
    }


//    @Override
//    public String toString() {
//        return "ProductCharacteristicType{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", measure='" + measure + '\'' +
//                ", characteristicType=" + characteristicType +
//                ", productCharacteristicCheckboxFieldList=" + productCharacteristicCheckboxFieldList +
//                ", productCharacteristicList=" + productCharacteristicList +
//                '}';
//    }
}

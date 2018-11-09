package com.web.shop.model.products;

import com.web.shop.model.enums.CharacteristicTypeEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ProductCharacteristicType")
public class ProductCharacteristicType implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "Name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "Measure", length = 30)
    @Size(min = 1, max = 30)
    private String measure;

    @Column(name = "characteristicType")
    @Enumerated(EnumType.STRING)
    private CharacteristicTypeEnum characteristicType;

    @OneToMany(mappedBy="productCharacteristicType", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //EAGER
    private List<CheckboxCharacteristicNameValues> checkboxCharacteristicNameValues;

    @OneToMany(mappedBy="productCharacteristicType", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //EAGER
    private List<ProductCharacteristic> productCharacteristics;

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

    public CharacteristicTypeEnum getCharacteristicType() {
        return characteristicType;
    }

    public void setCharacteristicType(CharacteristicTypeEnum characteristicType) {
        this.characteristicType = characteristicType;
    }

    public List<CheckboxCharacteristicNameValues> getCheckboxCharacteristicNameValues() {
        return checkboxCharacteristicNameValues;
    }
    public List<String> getCheckboxCharacteristicNameValuesToString() {
        List<String> listValues = new ArrayList<>();
        checkboxCharacteristicNameValues.forEach((i)->listValues.add(i.getValue()));
        return listValues;
    }

    public void setCheckboxCharacteristicNameValues(List<CheckboxCharacteristicNameValues> checkboxCharacteristicNameValues) {
        this.checkboxCharacteristicNameValues = checkboxCharacteristicNameValues;
    }

    public List<ProductCharacteristic> getProductCharacteristics() {
        return productCharacteristics;
    }

    public void setProductCharacteristics(List<ProductCharacteristic> productCharacteristics) {
        this.productCharacteristics = productCharacteristics;
    }

    @Override
    public String toString() {
        return "ProductCharacteristicType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                ", characteristicType=" + characteristicType +
                ", checkboxCharacteristicNameValues=" + checkboxCharacteristicNameValues +
                '}';
    }


}

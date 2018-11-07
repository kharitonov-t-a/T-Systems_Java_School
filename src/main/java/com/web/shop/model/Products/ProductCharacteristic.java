package com.web.shop.model.Products;

import com.web.shop.model.enums.CharacteristicTypeEnum;
import com.web.shop.model.enums.PaymentEnum;
import com.web.shop.model.enums.UserRolesEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ProductCharacteristic")
public class ProductCharacteristic implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "Name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "CharacteristicTableName")
    @Enumerated(EnumType.STRING)
    private CharacteristicTypeEnum characteristicTableName;

    @Column(name = "Measure", length = 30)
    @Size(min = 1, max = 30)
    private String measure;

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

    public CharacteristicTypeEnum getCharacteristicTableName() {
        return characteristicTableName;
    }

    public void setCharacteristicTableName(CharacteristicTypeEnum characteristicTableName) {
        this.characteristicTableName = characteristicTableName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "ProductCharacteristic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristicTableName=" + characteristicTableName +
                ", measure='" + measure + '\'' +
                '}';
    }
}

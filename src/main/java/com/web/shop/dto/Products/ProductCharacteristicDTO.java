package com.web.shop.dto.Products;

import com.web.shop.model.enums.CharacteristicTypeEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductCharacteristicDTO implements Serializable {

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    private CharacteristicTypeEnum characteristicTableName;

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
        return "ProductCharacteristicDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristicTableName=" + characteristicTableName +
                ", measure='" + measure + '\'' +
                '}';
    }
}

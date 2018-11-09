package com.web.shop.dto.products;

import com.web.shop.model.enums.CharacteristicTypeEnum;
import com.web.shop.model.products.CheckboxCharacteristicNameValues;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class ProductCharacteristicTypeDTO implements Serializable {


    public ProductCharacteristicTypeDTO(Integer id) {
        this.id = id;
    }

    public ProductCharacteristicTypeDTO() {
    }

    public interface ValidationDelete {
    }

    public interface ValidationCreate {
    }

    private Integer id;

    @Size(min = 3, max = 30, groups = {ValidationCreate.class})
    @NotBlank(groups = {ProductsCategoryDTO.ValidationCreate.class})
    private String name;

    @Size(min = 1, max = 30, groups = {ValidationCreate.class})
    private String measure;

    private CharacteristicTypeEnum characteristicType;

    private List<String> checkboxCharacteristicNameValuesString;
    private List<CheckboxCharacteristicNameValuesDTO> checkboxCharacteristicNameValues;

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

    public List<String> getCheckboxCharacteristicNameValuesString() {
        return checkboxCharacteristicNameValuesString;
    }

    public void setCheckboxCharacteristicNameValuesString(List<String> checkboxCharacteristicNameValuesString) {
        this.checkboxCharacteristicNameValuesString = checkboxCharacteristicNameValuesString;
    }


    public List<CheckboxCharacteristicNameValuesDTO> getCheckboxCharacteristicNameValues() {
        return checkboxCharacteristicNameValues;
    }

    public void setCheckboxCharacteristicNameValues(List<CheckboxCharacteristicNameValuesDTO> checkboxCharacteristicNameValues) {
        this.checkboxCharacteristicNameValues = checkboxCharacteristicNameValues;
    }

    @Override
    public String toString() {
        return "ProductCharacteristicTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristicType=" + characteristicType +
                ", measure='" + measure + '\'' +
                ", checkboxCharacteristicNameValuesString=" + checkboxCharacteristicNameValuesString +
                '}';
    }
}

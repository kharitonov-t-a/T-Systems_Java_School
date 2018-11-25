package com.web.shop.dto.product;

import com.web.shop.model.enums.CharacteristicType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductCharacteristicTypeDTO implements Serializable {


//    public ProductCharacteristicTypeDTO(Integer id) {
//        this.id = id;
//    }
//
//    public ProductCharacteristicTypeDTO() {
//    }

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Size(min = 1, max = 30)
    private String measure;

    private CharacteristicType characteristicType;

    private List<ProductCharacteristicCheckboxFieldDTO> productCharacteristicCheckboxFieldList = new ArrayList<>();

    private List<ProductCharacteristicDTO> productCharacteristicList = new ArrayList<>();

    private ProductCategoryDTO productCategory;

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

    public CharacteristicType getCharacteristicType() {
        return characteristicType;
    }

    public void setCharacteristicType(CharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    public List<ProductCharacteristicCheckboxFieldDTO> getProductCharacteristicCheckboxFieldList() {
        return productCharacteristicCheckboxFieldList;
    }

    public void setProductCharacteristicCheckboxFieldList(List<ProductCharacteristicCheckboxFieldDTO> productCharacteristicCheckboxFieldList) {
        this.productCharacteristicCheckboxFieldList = productCharacteristicCheckboxFieldList;
    }

    public List<ProductCharacteristicDTO> getProductCharacteristicList() {
        return productCharacteristicList;
    }

    public void setProductCharacteristicList(List<ProductCharacteristicDTO> productCharacteristicList) {
        this.productCharacteristicList = productCharacteristicList;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }
}

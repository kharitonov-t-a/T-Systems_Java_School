package com.web.shop.dto.product;

import com.web.shop.model.product.ProductCharacteristicCheckboxValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductCharacteristicCheckboxFieldDTO implements Serializable {

    private Integer id;

    private String value;

    private ProductCharacteristicTypeDTO productCharacteristicType;

    private List<ProductCharacteristicCheckboxValueDTO> productCharacteristicCheckboxValueList = new ArrayList<>();

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

    public ProductCharacteristicTypeDTO getProductCharacteristicType() {
        return productCharacteristicType;
    }

    public void setProductCharacteristicType(ProductCharacteristicTypeDTO productCharacteristicType) {
        this.productCharacteristicType = productCharacteristicType;
    }

    public List<ProductCharacteristicCheckboxValueDTO> getProductCharacteristicCheckboxValueList() {
        return productCharacteristicCheckboxValueList;
    }

    public void setProductCharacteristicCheckboxValueList(List<ProductCharacteristicCheckboxValueDTO> productCharacteristicCheckboxValueList) {
        this.productCharacteristicCheckboxValueList = productCharacteristicCheckboxValueList;
    }


//    @Override
//    public String toString() {
//        return "ProductCharacteristicCheckboxFieldDTO{" +
//                "id=" + id +
//                ", value='" + value + '\'' +
//                ", productCharacteristicType=" + productCharacteristicType +
//                '}';
//    }
}

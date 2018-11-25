package com.web.shop.dto.product;

import com.web.shop.model.product.ProductCharacteristicType;
import com.web.shop.validator.characterCode.EnableUniqueCharacterCodeConstraint;
import com.web.shop.validator.characterCode.UniqueCharacterCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EnableUniqueCharacterCodeConstraint
public class ProductCategoryDTO implements Serializable {

    public ProductCategoryDTO(Integer productsCategoryId) {
        this.id = productsCategoryId;
    }

    public ProductCategoryDTO() {
    }


//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

//    @Override
//    public String toString() {
//        return "ProductCategoryDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", parent=" + parent +
//                ", leftKey=" + leftKey +
//                ", rightKey=" + rightKey +
//                ", level=" + level +
//                ", productList=" + productList +
//                '}';
//    }

//
//    public interface ValidationDelete {
//    }
//
//    public interface ValidationCreate {
//    }
//

    private Integer id;

    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Size(min = 3, max = 30)
    @NotBlank
    @UniqueCharacterCode
    private String characterCode;

//    @NotEmpty
    private Integer parent;

    private Integer leftKey = 0;

    private Integer rightKey = 0;

    private Integer level = 0;

//    @NotBlank
//    private String imageUrl;

    private List<ProductDTO> productList = new ArrayList<>();

    private List<ProductCharacteristicTypeDTO> productCharacteristicTypeList = new ArrayList<>();

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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(Integer leftKey) {
        this.leftKey = leftKey;
    }

    public Integer getRightKey() {
        return rightKey;
    }

    public void setRightKey(Integer rightKey) {
        this.rightKey = rightKey;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }


    public List<ProductCharacteristicTypeDTO> getProductCharacteristicTypeList() {
        return productCharacteristicTypeList;
    }

    public void setProductCharacteristicTypeList(List<ProductCharacteristicTypeDTO> productCharacteristicTypeList) {
        this.productCharacteristicTypeList = productCharacteristicTypeList;
    }
}

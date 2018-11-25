package com.web.shop.model.product;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "characterCode", length = 30, unique = true)
    @Size(min = 3, max = 30)
    @NotBlank
    private String characterCode;

    @Column(name = "name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "parent", nullable = false, length = 6)
    private Integer parent;

    @Column(name = "leftKey", nullable = false, length = 10)
    private Integer leftKey = 0;

    @Column(name = "rightKey", nullable = false, length = 10)
    private Integer rightKey = 0;

    @Column(name = "level", nullable = false, length = 10)
    private Integer level = 0;

//    @Column(name = "imageUrl")
//    @NotBlank
//    private String imageUrl;

    @OneToMany(mappedBy="productCategory", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy="productCategory", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ProductCharacteristicType> productCharacteristicTypeList = new ArrayList<>();

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public List<ProductCharacteristicType> getProductCharacteristicTypeList() {
        return productCharacteristicTypeList;
    }

    public void setProductCharacteristicTypeList(List<ProductCharacteristicType> productCharacteristicTypeList) {
        this.productCharacteristicTypeList = productCharacteristicTypeList;
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
//        return "ProductCategory{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", parent=" + parent +
//                ", leftKey=" + leftKey +
//                ", rightKey=" + rightKey +
//                ", level=" + level +
//                ", productList=" + productList +
//                '}';
//    }
}

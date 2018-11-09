package com.web.shop.dto.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductsCategoryDTO implements Serializable {

    public ProductsCategoryDTO(Integer productsCategoryId) {
        this.id = productsCategoryId;
    }

    public ProductsCategoryDTO() {
    }

    public interface ValidationDelete {
    }

    public interface ValidationCreate {
    }

    @Min(value = 2, groups={ValidationDelete.class})
    private Integer id;

    @Size(min = 3, max = 30, groups = {ValidationCreate.class})
    @NotBlank(groups = {ValidationCreate.class})
    private String name;

//    @NotEmpty
    private Integer parent;

    private Integer leftKey = 0;

    private Integer rightKey = 0;

    private Integer level = 0;

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

    @Override
    public String toString() {
        return "ProductsCategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", leftKey=" + leftKey +
                ", rightKey=" + rightKey +
                ", level=" + level +
                '}';
    }
}

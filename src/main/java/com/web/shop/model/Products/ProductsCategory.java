package com.web.shop.model.Products;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ProductsCategory")
public class ProductsCategory implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "Name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "Parent", nullable = false, length = 6)
    private Integer parent;

    @Column(name = "Leftkey", nullable = false, length = 10)
    private Integer leftKey = 0;

    @Column(name = "Rightkey", nullable = false, length = 10)
    private Integer rightKey = 0;

    @Column(name = "Level", nullable = false, length = 10)
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
        return "ProductsCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", Left_key=" + leftKey +
                ", right_key=" + rightKey +
                ", level=" + level +
                '}';
    }


}

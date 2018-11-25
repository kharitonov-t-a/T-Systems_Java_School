package com.web.shop.model.product;

import com.web.shop.model.order.OrderProduct;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "characterCode", length = 30)
    @UniqueElements
    @Size(min = 3, max = 30)
    @NotBlank
    private String characterCode;

    @Column(name = "price", precision=10, scale=2)
    private BigDecimal price;

    @Column(name = "stockQuantity", length = 10)
//    @Size(min = 1, max = 10)
//    @NotBlank
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristic> productCharacteristicList = new ArrayList<>();

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList = new ArrayList<>();

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

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCharacteristic> getProductCharacteristicList() {
        return productCharacteristicList;
    }

    public void setProductCharacteristicList(List<ProductCharacteristic> productCharacteristicList) {
        this.productCharacteristicList = productCharacteristicList;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

//    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ProductImage> productImageList;

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", productCategory=" + productCategory +
//                ", stockQuantity=" + stockQuantity +
//                ", productCharacteristicList=" + productCharacteristicList +
//                ", orderProductList=" + orderProductList +
//                '}';
//    }
}

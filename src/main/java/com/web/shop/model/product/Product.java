package com.web.shop.model.product;

import com.web.shop.model.enums.Sorting;
import com.web.shop.model.order.OrderProduct;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

//    public Product() {
//    }
//
//
//    public Product(Product product, Long count) {
//        this.id = product.getId();
//        this.name = product.getName();
//        this.characterCode = product.getCharacterCode();
//        this.price = product.price;
//        this.stockQuantity = product.getStockQuantity();
//        this.productCategory = product.getProductCategory();
//        this.productCharacteristicList = product.getProductCharacteristicList();
//        this.orderProductList = product.orderProductList;
//    }


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
    @Size(min = 3, max = 30)
    @NotBlank
    private String characterCode;

    @Column(name = "price", precision=10, scale=2)
    private BigDecimal price;

    @Transient
    private BigDecimal priceFilterMin;
    @Transient
    private BigDecimal priceFilterMax;
    @Transient
    private Sorting sort;
    @Transient
    private Integer countSlaveCharacteristics;


    @Column(name = "stockQuantity", length = 10)
//    @Size(min = 1, max = 10)
//    @NotBlank
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @OrderBy("id asc")
    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCharacteristic> productCharacteristicList;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList;

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

    public BigDecimal getPriceFilterMin() {
        return priceFilterMin;
    }

    public void setPriceFilterMin(BigDecimal priceFilterMin) {
        this.priceFilterMin = priceFilterMin;
    }

    public BigDecimal getPriceFilterMax() {
        return priceFilterMax;
    }

    public void setPriceFilterMax(BigDecimal priceFilterMax) {
        this.priceFilterMax = priceFilterMax;
    }

    public Sorting getSort() {
        return sort;
    }

    public void setSort(Sorting sort) {
        this.sort = sort;
    }

    public Integer getCountSlaveCharacteristics() {
        return countSlaveCharacteristics;
    }

    public void setCountSlaveCharacteristics(Integer countSlaveCharacteristics) {
        this.countSlaveCharacteristics = countSlaveCharacteristics;
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

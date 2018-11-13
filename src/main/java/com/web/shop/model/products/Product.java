package com.web.shop.model.products;

import com.web.shop.model.orders.Order;
import com.web.shop.model.orders.OrderProduct;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @Column(name = "Name", length = 30)
    @Size(min = 3, max = 30)
    @NotBlank
    private String name;

    @Column(name = "Price", precision=10, scale=2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ProductsCategoryId", nullable = false)
    private ProductsCategory productsCategory;

    @Column(name = "StockQuantity", length = 10)
//    @Size(min = 1, max = 10)
//    @NotBlank
    private Integer stockQuantity;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ProductCharacteristic> productCharacteristic;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;

    public List<ProductCharacteristic> getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristic> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductsCategory getProductsCategory() {
        return productsCategory;
    }

    public void setProductsCategory(ProductsCategory productsCategory) {
        this.productsCategory = productsCategory;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", productsCategory=" + productsCategory +
//                ", stockQuantity=" + stockQuantity +
//                ", productCharacteristic=" + productCharacteristic +
//                ", orderProducts=" + orderProducts +
//                '}';
//    }
}

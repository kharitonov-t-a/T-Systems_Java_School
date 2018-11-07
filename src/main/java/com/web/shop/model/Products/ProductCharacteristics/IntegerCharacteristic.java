package com.web.shop.model.Products.ProductCharacteristics;

import com.web.shop.model.Products.Product;
import com.web.shop.model.Products.ProductCharacteristic;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "IntegerCharacteristics")
public class IntegerCharacteristic implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) //EAGER
    @JoinColumn(name = "ProductCharacteristicId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductCharacteristic productCharacteristic;

    @ManyToOne(fetch = FetchType.LAZY) //EAGER
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "Value")
    @NotBlank
    private Integer value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCharacteristic getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(ProductCharacteristic productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntegerCharacteristic{" +
                "id=" + id +
                ", productCharacteristic=" + productCharacteristic +
                ", product=" + product +
                ", value=" + value +
                '}';
    }
}

package com.web.shop.model.orders;

import com.web.shop.model.products.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "OrderProducts")
public class OrderProduct implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", nullable = false, length = 6)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "OrderId", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "Price", precision=10, scale=2)
    private Double price;

//    @Column(name = "Count", length = 10)
//    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Integer getCount() {
//        return count;
//    }

//    public void setCount(Integer count) {
//        this.count = count;
//    }

//    @Override
//    public String toString() {
//        return "OrderProduct{" +
//                "id=" + id +
//                ", order=" + order +
//                ", product=" + product +
//                ", price=" + price +
////                ", count=" + count +
//                '}';
//    }
}

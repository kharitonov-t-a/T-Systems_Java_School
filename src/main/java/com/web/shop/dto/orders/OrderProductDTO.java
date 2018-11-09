package com.web.shop.dto.orders;

import com.web.shop.dto.products.ProductDTO;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class OrderProductDTO implements Serializable {

    private Integer id;

    private OrderDTO order;

    private ProductDTO product;

    @NotBlank
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO orderDTO) {
        this.order = orderDTO;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderProductDTO{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", price=" + price +
                '}';
    }
}

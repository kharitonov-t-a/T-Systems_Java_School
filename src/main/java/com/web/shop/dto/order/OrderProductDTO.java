package com.web.shop.dto.order;

import com.web.shop.dto.product.ProductDTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderProductDTO implements Serializable {

    private Integer id;

    private OrderDTO order;

    private ProductDTO product;

    private BigDecimal price;

    private Boolean inStock = true;

    private Integer count;

    public OrderProductDTO(OrderDTO order, ProductDTO product, BigDecimal price) {
        this.order = order;
        this.product = product;
        this.price = price;
    }

    public OrderProductDTO() {
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

//    public Integer getCount() {
//        return count;
//    }

//    public void setCount(Integer count) {
//        this.count = count;
//    }

//    @Override
//    public String toString() {
//        return "OrderProductDTO{" +
//                "id=" + id +
//                ", order=" + order +
//                ", product=" + product +
//                ", price=" + price +
////                ", count=" + count +
//                '}';
//    }
}

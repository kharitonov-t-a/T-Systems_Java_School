package com.web.shop.dto.product;

import com.web.shop.model.product.Product;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ProductImageDTO implements Serializable {

    private Integer id;

    @NotBlank
    private String imageUrl;

    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

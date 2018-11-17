package com.web.shop.exceptions;

import com.web.shop.dto.product.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products in Stock")
public class NoProductsInStockException extends GlobalCustomException  {
    private ProductDTO productDTO;

    public NoProductsInStockException(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public NoProductsInStockException(String message, ProductDTO productDTO) {
        super(message);
        this.productDTO = productDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}

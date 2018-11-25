package com.web.shop.exceptions;

import com.web.shop.dto.product.ProductCategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Error in products category structure")
public class CheckProductsCategoryException extends GlobalCustomException {

    private List<ProductCategoryDTO> listProductCategoryDTO;
    public List<ProductCategoryDTO> getListProductCategoryDTO() {
        return listProductCategoryDTO;
    }

    public CheckProductsCategoryException() {
    }

    public CheckProductsCategoryException(String message) {
        super(message);
    }

    public CheckProductsCategoryException(String message, List<ProductCategoryDTO> listProductCategoryDTO) {
        super(message);
        this.listProductCategoryDTO = listProductCategoryDTO;
    }



}

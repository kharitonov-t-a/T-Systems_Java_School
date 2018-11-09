package com.web.shop.exceptions;

import com.web.shop.dto.products.ProductsCategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "Error in products category structure")
public class CheckProductsCategoryException extends GlobalCustomException {

    private List<ProductsCategoryDTO> listProductsCategoryDTO;
    public List<ProductsCategoryDTO> getListProductsCategoryDTO() {
        return listProductsCategoryDTO;
    }

    public CheckProductsCategoryException() {
    }

    public CheckProductsCategoryException(String message) {
        super(message);
    }

    public CheckProductsCategoryException(String message, List<ProductsCategoryDTO> listProductsCategoryDTO) {
        super(message);
        this.listProductsCategoryDTO = listProductsCategoryDTO;
    }



}

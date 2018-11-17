package com.web.shop.controler.advice;

import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.NoProductsInStockException;
import com.web.shop.exceptions.SaveUserException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(SaveUserException.class)
    public String saveUserException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "error/exception";
    }

    @ExceptionHandler(CheckProductsCategoryException.class)
    public String checkProductsCategoryException(CheckProductsCategoryException exception, Model model) {
        model.addAttribute("exceptionMessage", exception.getMessage());
        model.addAttribute("listProductsCategoryDTO", exception.getListProductCategoryDTO());
        return "error/productsCategoryException";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoProductsInStockException.class)
    public String noProductsInStockException(NoProductsInStockException exception, Model model) {
        model.addAttribute("exceptionMessage", exception.getMessage());
        model.addAttribute("productDTO", exception.getProductDTO());
        return "error/noProductsInStock";
    }


}

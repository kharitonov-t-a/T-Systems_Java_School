package com.web.shop.controler.advice;

import com.web.shop.exceptions.CheckProductsCategoryException;
import com.web.shop.exceptions.CreateDaoException;
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CreateDaoException.class)
    public String createDaoException(CreateDaoException exception, Model model) {
        model.addAttribute("exceptionMessage", exception.getMessage());
        return "error/createDaoException";
    }


}

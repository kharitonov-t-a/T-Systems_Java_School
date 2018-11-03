package com.web.shop.controler;

import com.web.shop.exceptions.SaveUserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(SaveUserException.class)
    public String saveUserException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "error/exception";
    }


}

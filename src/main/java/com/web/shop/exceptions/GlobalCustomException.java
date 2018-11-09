package com.web.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Global Error")
public class GlobalCustomException extends Exception {
    public GlobalCustomException() {
    }

    public GlobalCustomException(String message) {
        super(message);
    }
}

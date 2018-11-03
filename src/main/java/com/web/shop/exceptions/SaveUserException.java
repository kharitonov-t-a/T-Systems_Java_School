package com.web.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User with this email already exists")
public class SaveUserException extends Exception {

    public SaveUserException() {
    }

    public SaveUserException(String message) {
        super(message);
    }
}

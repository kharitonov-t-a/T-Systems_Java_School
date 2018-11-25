package com.web.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Create dao exception")
public class CreateDaoException extends GlobalCustomException {

    public CreateDaoException() {
    }

    public CreateDaoException(String message) {
        super(message);
    }
}
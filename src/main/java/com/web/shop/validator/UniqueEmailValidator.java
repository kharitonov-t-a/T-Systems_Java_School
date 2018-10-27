package com.web.shop.validator;

import com.web.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String>{

    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || userService.findByEmail(value) != null) {
            return false;
        }
        return true;
    }
}
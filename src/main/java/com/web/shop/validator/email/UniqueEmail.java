package com.web.shop.validator.email;

import com.web.shop.dto.user.UserDTO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueEmail {

    String message() default "{UniqueEmail}";

}
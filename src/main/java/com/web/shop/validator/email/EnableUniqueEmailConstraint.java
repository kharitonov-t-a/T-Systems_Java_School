package com.web.shop.validator.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface EnableUniqueEmailConstraint {

    String message() default "Field must be unique!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
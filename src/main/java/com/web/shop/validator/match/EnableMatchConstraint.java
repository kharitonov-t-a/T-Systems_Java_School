package com.web.shop.validator.match;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchValidator.class)
@Documented
public @interface EnableMatchConstraint {

    String message() default "Fields must match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
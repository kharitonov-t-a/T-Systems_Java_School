package com.web.shop.validator.characterCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCharacterCodeValidator.class)
@Documented
public @interface EnableUniqueCharacterCodeConstraint {

    String message() default "Field must be unique!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
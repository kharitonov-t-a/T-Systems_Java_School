package com.web.shop.validator.characterCode;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueCharacterCode {

    String message() default "{UniqueCharacterCode}";

}
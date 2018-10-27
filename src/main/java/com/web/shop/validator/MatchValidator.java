package com.web.shop.validator;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Locale;

public class MatchValidator implements  ConstraintValidator<EnableMatchConstraint, Object> {

    @Autowired
    MessageSource messageSource;

    @Override
    public void initialize(final EnableMatchConstraint constraint) {}

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext context) {
        boolean result = true;
        try {
            String mainField, secondField, message;
            Object firstObj, secondObj;

            final Class<?> clazz = o.getClass();
            final Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Match.class)) {
                    mainField = field.getName();
                    secondField = field.getAnnotation(Match.class).field();
                    message = messageSource.getMessage(field.getAnnotation(Match.class).message(), new String[]{}, Locale.getDefault());

                    if (message == null || "".equals(message))
                        message = "Fields " + mainField + " and " + secondField + " must match!";

                    firstObj = BeanUtils.getProperty(o, mainField);
                    secondObj = BeanUtils.getProperty(o, secondField);

                    result = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
                    if (!result) {
                        context.disableDefaultConstraintViolation();
                        context.buildConstraintViolationWithTemplate(message).addPropertyNode(mainField).addConstraintViolation();
                        break;
                    }
                }
            }
        } catch (final Exception e) {
            // ignore
            //e.printStackTrace();
        }
        return result;
    }
}
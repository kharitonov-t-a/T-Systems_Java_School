package com.web.shop.validator.characterCode;

import com.web.shop.dto.product.ProductCategoryDTO;
import com.web.shop.service.interfaces.product.ProductCategoryService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class UniqueCharacterCodeValidator implements ConstraintValidator<EnableUniqueCharacterCodeConstraint, Object>{

    @Autowired
    ProductCategoryService productCategoryService;

    @Override
    public void initialize( final EnableUniqueCharacterCodeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext context) {

        try {

            Object characterCodeField, idObj;

//            Object obj = BeanUtils.getProperty(o, "id");
            final Class<?> clazz = o.getClass();
            final Field[] fields = clazz.getDeclaredFields();
            idObj = BeanUtils.getProperty(o, "id");


            for (Field field : fields) {
                // find fields with annotation @UniqueCharacterCodeField
                if (field.isAnnotationPresent(UniqueCharacterCode.class)) {
                    characterCodeField = BeanUtils.getProperty(o, field.getName());

                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("").addPropertyNode(field.getName()).addConstraintViolation();

                    // if field not null
                    if(characterCodeField != null){

                        ProductCategoryDTO productCategory = productCategoryService.findNodeByCharacterCode(String.valueOf(characterCodeField));

    //                   if user exist in DB and it is not current user
                        if(productCategory != null && (idObj == null || Integer.valueOf(idObj.toString()) != productCategory.getId())){
                                return false;
                        }
                    }else{
                        return false;
                    }
                }
            }
        } catch (final Exception e) {
            // ignore
            //e.printStackTrace();
        }
        return true;
    }
}
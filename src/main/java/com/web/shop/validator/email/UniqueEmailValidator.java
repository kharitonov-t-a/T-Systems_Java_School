package com.web.shop.validator.email;

import com.web.shop.dto.user.UserDTO;
import com.web.shop.security.UserSecurityService;
import com.web.shop.service.interfaces.user.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class UniqueEmailValidator  implements ConstraintValidator<EnableUniqueEmailConstraint, Object>{

    @Autowired
    UserService userService;

    @Autowired
    UserSecurityService userSecurityService;

    @Override
    public void initialize( final EnableUniqueEmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext context) {

        try {

            Object emailField, idObj;

//            Object obj = BeanUtils.getProperty(o, "id");
            final Class<?> clazz = o.getClass();
            final Field[] fields = clazz.getDeclaredFields();
            idObj = BeanUtils.getProperty(o, "id");
            // if id from form == null

            for (Field field : fields) {
                // find fields with annotation @UniqueEmail
                if (field.isAnnotationPresent(UniqueEmail.class)) {
                    String nameEmailField = field.getName();
                    emailField = BeanUtils.getProperty(o, field.getName());

                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("").addPropertyNode(nameEmailField).addConstraintViolation();

                    // if field not null
                    if(emailField != null){

                        UserDTO userByEmail = userService.findByEmail(String.valueOf(emailField));

    //                   if user exist in DB and it is not current user
                        if(userByEmail != null &&
                                !String.valueOf(emailField).equalsIgnoreCase(UserSecurityService.getPrincipal())){
                            //if create new user or edit current user
                            if(idObj == null){

                                return false;
                            }else{
                                // if id user in DB != id from form
                                if(userByEmail.getId().compareTo(new Integer(idObj.toString())) != 0){
                                    return false;
                                }
                            }
                        }else if(userByEmail != null){
                            // if admin try change other user on his email
                            if(idObj != null && userByEmail.getId().compareTo(new Integer(idObj.toString())) != 0){
                                return false;
                            }
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
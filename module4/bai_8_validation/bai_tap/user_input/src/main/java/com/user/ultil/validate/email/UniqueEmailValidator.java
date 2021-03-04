//package com.user.ultil.validate.email;
//
//import com.user.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//
//@Component
//public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        //Phần code kiểm tra validate
//        return value != null && !userService.checkExistUser(value);
//        return true;
//    }
//}
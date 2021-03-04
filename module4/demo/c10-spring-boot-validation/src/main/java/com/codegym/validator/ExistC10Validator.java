package com.codegym.validator;

import com.codegym.annotation.ExistC10;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistC10Validator implements ConstraintValidator<ExistC10, String> {
   public void initialize(ExistC10 constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      if (!obj.contains("C10")) {
         return false;
      }
      return true;
   }
}

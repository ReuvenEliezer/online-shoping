package com.config;


import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CommonsEmailValidator implements ConstraintValidator<Email, String> {


    private static final boolean ALLOW_LOCAL = false;
    private EmailValidator realValidator = EmailValidator.getInstance(ALLOW_LOCAL);

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if( s == null ) return true;
        return realValidator.isValid(s);
    }
}
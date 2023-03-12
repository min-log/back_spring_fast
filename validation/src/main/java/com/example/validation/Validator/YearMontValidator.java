package com.example.validation.Validator;

import com.example.validation.anotation.YearMonth;

import javax.swing.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMontValidator implements ConstraintValidator<YearMonth,String> {
    String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //value yyyyMM  value+"01"
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern("yyyyMM"));

        }catch (Exception e){
            return false;
        }

        return true;
    }
}

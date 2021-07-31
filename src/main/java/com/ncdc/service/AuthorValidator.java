package com.ncdc.service;

import com.ncdc.domain.Author;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidator implements ConstraintValidator<ValidAuthor, Author> {

    @Override
    public boolean isValid(Author value, ConstraintValidatorContext context) {
        return startsWithA(value.getName()) || startsWithA(value.getSurname());
    }

    private boolean startsWithA(String value) {
        return value != null && value.startsWith("A");
    }
}

package com.ncdc.service;

import com.ncdc.domain.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorValidatorTest {

    private AuthorValidator authorValidator = new AuthorValidator();

    @Test
    void trueWhenValidAuthor() {
        Author author = new Author("Author name", "surname");
        assertTrue(authorValidator.isValid(author, null));
    }

    @Test
    void falseWhenNotValidAuthor() {
        Author author = new Author("name", "surname");
        assertFalse(authorValidator.isValid(author, null));
    }
}
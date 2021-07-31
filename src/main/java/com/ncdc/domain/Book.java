package com.ncdc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.StringJoiner;

@Document
public class Book {

    @Id
    private BigInteger id;
    @Valid
    private Author author;
    private String title;
    private String isbn;

    public Book() {
    }

    public Book(BigInteger id, Author author, String title, String isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public BigInteger getId() {
        return id;
    }

    public Book setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]").add("id=" + id)
                .add("author=" + author)
                .add("title='" + title + "'")
                .add("isbn='" + isbn + "'")
                .toString();
    }
}

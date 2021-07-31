package com.ncdc.domain;

import com.ncdc.service.ValidAuthor;

import java.util.StringJoiner;

@ValidAuthor
public class Author {

    private String name;
    private String surname;

    public Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Author setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Author author = (Author) o;

        if (name != null ? !name.equals(author.name) : author.name != null) { return false; }
        return surname != null ? surname.equals(author.surname) : author.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]").add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .toString();
    }
}

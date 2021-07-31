package com.ncdc.service;

import com.ncdc.domain.Author;
import com.ncdc.domain.Book;
import com.ncdc.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DefaultBookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void successBookSave() {
        Author author = new Author("Author Eric", "Evans");
        String title = "Domain-Driven Design";
        String isbn = "978-0321125217";
        Book book = bookService.save(new Book(null, author, title, isbn)).block();
        assertNotNull(book);
        assertNotNull(book.getId());
        assertThat(book.getAuthor(), is(author));
        assertThat(book.getTitle(), is(book.getTitle()));
        assertThat(book.getIsbn(), is(book.getIsbn()));
    }

    @Test
    void errorWhenAuthorValidationFailed() {
        Author author = new Author("Eric", "Evans");
        String title = "Domain-Driven Design";
        String isbn = "978-0321125217";
        assertThrows(
                ConstraintViolationException.class,
                () -> bookService.save(new Book(null, author, title, isbn)).block());
    }

    @Test
    void successRetrieveAllBooks() {
        Author author = new Author("Author Eric", "Evans");
        String title = "Domain-Driven Design";
        String isbn = "978-0321125217";
        bookRepository.deleteAll().block();
        bookService.save(new Book(null, author, title, isbn)).block();
        bookService.save(new Book(null, author, title, isbn)).block();
        List<Book> books = bookService.getAllBooks().collectList().block();
        assertNotNull(books);
        assertThat(books.size(), is(2));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll().block();
    }
}
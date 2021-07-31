package com.ncdc.web;

import com.ncdc.domain.Book;
import com.ncdc.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public Mono<ResponseEntity<Book>> addBook(@RequestBody @Valid Mono<Book> book) {
        return book.flatMap(bookService::save)
                .map(ResponseEntity::ok)
                .onErrorReturn(WebExchangeBindException.class, ResponseEntity.badRequest().build());
    }

    @GetMapping("/getAllBooks")
    public Flux<Book> listBooks() {
        return bookService.getAllBooks();
    }
}

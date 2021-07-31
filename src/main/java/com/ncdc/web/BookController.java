package com.ncdc.web;

import com.ncdc.domain.Book;
import com.ncdc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBookForm")
    public Rendering addBookForm() {
        return Rendering.view("addBook").modelAttribute("book", new Book()).build();
    }

    @PostMapping("/addBook")
    public Mono<Rendering> addBook(@Valid Book book, BindingResult result) {
        return Mono.just(book)
                .filter(b -> !result.hasErrors())
                .flatMap(bookService::save)
                .map(b -> Rendering.redirectTo("bookList").build())
                .defaultIfEmpty(Rendering.view("addBook").modelAttribute("book", book).build());
    }

    @GetMapping("/bookList")
    public Rendering listBooks() {
        return Rendering.view("bookList").modelAttribute("bookList", bookService.getAllBooks()).build();
    }
}

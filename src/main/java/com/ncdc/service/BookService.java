package com.ncdc.service;

import com.ncdc.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> save(Book book);

    Flux<Book> getAllBooks();
}

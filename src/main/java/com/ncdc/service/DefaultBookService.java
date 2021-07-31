package com.ncdc.service;

import com.ncdc.domain.Book;
import com.ncdc.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DefaultBookService implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBookService.class);
    private final BookRepository bookRepository;

    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Mono<Book> save(Book book) {
        return bookRepository.save(book)
                .doOnSuccess(b -> LOGGER.info("Book saved, id: {}", b.getId()))
                .doOnError(e -> LOGGER.error("Error while saving book {}", book, e));
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll()
                .doOnError(e -> LOGGER.error("Error while retrieving books.", e));
    }
}

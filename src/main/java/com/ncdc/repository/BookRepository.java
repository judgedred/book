package com.ncdc.repository;

import com.ncdc.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.math.BigInteger;

public interface BookRepository extends ReactiveMongoRepository<Book, BigInteger> {

}

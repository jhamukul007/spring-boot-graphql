package com.graphql.services;

import com.graphql.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> getBookById(String id);

    Book createBook(String name);

}

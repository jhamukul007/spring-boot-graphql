package com.graphql.services;

import com.graphql.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookById(String id);

    Book createBook(String name);

}

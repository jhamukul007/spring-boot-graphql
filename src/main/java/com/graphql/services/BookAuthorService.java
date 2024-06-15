package com.graphql.services;

import com.graphql.models.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    BookAuthor createBookAuthor(String bookId, String authorName);
    List<BookAuthor> getBookAuthorByBookId(String bookId);
}

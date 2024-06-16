package com.graphql.controllers;

import com.graphql.models.BookAuthor;
import com.graphql.services.BookAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    @MutationMapping
    public BookAuthor createBookAuthor(@Argument String bookId, @Argument String authorName) {
        return bookAuthorService.createBookAuthor(bookId, authorName);
    }

    @QueryMapping
    public List<BookAuthor> getBookAuthorByBookId(@Argument String bookId) {
        return bookAuthorService.getBookAuthorByBookId(bookId);
    }

    @QueryMapping
    public List<BookAuthor> getAllBookAuthor() {
        return bookAuthorService.getAllBooks();
    }

}

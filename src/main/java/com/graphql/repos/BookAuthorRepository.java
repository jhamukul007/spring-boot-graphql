package com.graphql.repos;

import com.graphql.models.BookAuthor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookAuthorRepository {

    private final List<BookAuthor> bookAuthors;

    public BookAuthorRepository() {
        this.bookAuthors = new ArrayList<>();
    }

    public List<BookAuthor> getBookAuthors() {
        return List.copyOf(bookAuthors);
    }

    public List<BookAuthor> getBookAuthorById(String id) {
        return this.bookAuthors
                .stream()
                .filter(bookAuthor -> Objects.nonNull(bookAuthor.getBook()))
                .filter(bookAuthor -> Objects.equals(bookAuthor.getBook().getId(), id))
                .collect(Collectors.toList());
    }

    public void saveBookAuthor(BookAuthor bookAuthor) {
        this.bookAuthors.add(bookAuthor);
    }
}

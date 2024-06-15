package com.graphql.repos;

import com.graphql.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public Book getBookById(String id) {
        return this.books.stream().filter(book -> Objects.equals(id, book.getId()))
                .findFirst().orElse(null);
    }

    public void saveBook(Book book) {
        this.books.add(book);
    }
}


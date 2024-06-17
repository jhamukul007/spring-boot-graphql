package com.graphql.services.impl;

import com.graphql.repos.BookRepository;
import com.graphql.services.BookService;
import com.graphql.models.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(String name) {
        Book book = new Book(name);
        bookRepository.save(book);
        return book;
    }

}

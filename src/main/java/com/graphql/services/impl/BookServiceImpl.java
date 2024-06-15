package com.graphql.services.impl;

import com.graphql.services.BookService;
import com.graphql.models.Book;
import com.graphql.repos.BookRepository;
import com.graphql.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book createBook(String name) {
        Book book = new Book(AppUtils.randomStr(), name);
        bookRepository.saveBook(book);
        return book;
    }

}

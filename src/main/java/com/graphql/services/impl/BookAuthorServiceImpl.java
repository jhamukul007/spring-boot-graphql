package com.graphql.services.impl;

import com.graphql.models.Author;
import com.graphql.models.Book;
import com.graphql.models.BookAuthor;
import com.graphql.repos.BookAuthorRepository;
import com.graphql.services.AuthorService;
import com.graphql.services.BookAuthorService;
import com.graphql.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookAuthorServiceImpl implements BookAuthorService {
    private final BookAuthorRepository bookAuthorRepository;
    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public BookAuthor createBookAuthor(String bookId, String authorName) {
        Optional<Book> bookOP = bookService.getBookById(bookId);
        Book book = bookOP.orElseThrow(() -> new IllegalArgumentException("No Book Found"));
        Author author = authorService.getAuthorByName(authorName)
                .orElse(authorService.saveAuthor(authorName));

        BookAuthor bookAuthor = new BookAuthor(book, author);
        bookAuthorRepository.save(bookAuthor);
        return bookAuthor;
    }

    @Override
    public List<BookAuthor> getBookAuthorByBookId(String bookId) {
        return bookAuthorRepository.findBookAuthorByBook_id(bookId);
    }

    @Override
    public List<BookAuthor> getAllBooks() {
        return bookAuthorRepository.findAll();
    }
}

package com.graphql.services.impl;

import com.graphql.models.Author;
import com.graphql.models.Book;
import com.graphql.models.BookAuthor;
import com.graphql.repos.BookAuthorRepository;
import com.graphql.services.AuthorService;
import com.graphql.services.BookAuthorService;
import com.graphql.services.BookService;
import com.graphql.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAuthorServiceImpl implements BookAuthorService {
    private final BookAuthorRepository bookAuthorRepository;
    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public BookAuthor createBookAuthor(String bookId, String authorName) {
        Book book = bookService.getBookById(bookId);
        if (book == null) throw new IllegalArgumentException("No Book Found");
        Author author = authorService.getAuthorByName(authorName);
        if (author == null) {
            author = authorService.saveAuthor(authorName);
        }
        BookAuthor bookAuthor = new BookAuthor(AppUtils.randomStr(), book, author);
        bookAuthorRepository.saveBookAuthor(bookAuthor);
        return bookAuthor;
    }

    @Override
    public List<BookAuthor> getBookAuthorByBookId(String bookId) {
        return bookAuthorRepository.getBookAuthorById(bookId);
    }

    @Override
    public List<BookAuthor> getAllBooks() {
        return bookAuthorRepository.getBookAuthors();
    }
}

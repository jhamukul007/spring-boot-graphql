package com.graphql.services.impl;

import com.graphql.models.Author;
import com.graphql.repos.AuthorRepository;
import com.graphql.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    public Author saveAuthor(String authorName) {
        Author author = new Author(authorName);
        authorRepository.save(author);
        return author;
    }
}

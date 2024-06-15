package com.graphql.services.impl;

import com.graphql.models.Author;
import com.graphql.repos.AuthorRepository;
import com.graphql.services.AuthorService;
import com.graphql.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author getAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }

    @Override
    public Author saveAuthor(String authorName) {
        Author author = new Author(AppUtils.randomStr(), authorName);
        authorRepository.saveAuthor(author);
        return author;
    }
}

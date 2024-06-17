package com.graphql.services;

import com.graphql.models.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> getAuthorByName(String name);
    Author saveAuthor(String authorName);

}

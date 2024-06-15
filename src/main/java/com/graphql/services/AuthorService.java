package com.graphql.services;

import com.graphql.models.Author;

public interface AuthorService {
    Author getAuthorByName(String name);
    Author saveAuthor(String authorName);

}

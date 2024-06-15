package com.graphql.repos;

import com.graphql.models.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class AuthorRepository {

    private final List<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();
    }

    public List<Author> getBooks() {
        return List.copyOf(authors);
    }

    public Author getAuthorById(String id) {
        return this.authors.stream().filter(author -> Objects.equals(id, author.getId()))
                .findFirst().orElse(null);
    }

    public void saveAuthor(Author author) {
        this.authors.add(author);
    }

    public Author getAuthorByName(String name){
        return this.authors.stream().filter(author -> Objects.equals(name, author.getName()))
                .findFirst().orElse(null);
    }

}

package com.graphql.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookAuthor {
    private String id;
    private Book book;
    private Author author;
}

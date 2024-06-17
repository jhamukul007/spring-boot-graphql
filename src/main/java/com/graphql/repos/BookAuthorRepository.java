package com.graphql.repos;

import com.graphql.models.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, String> {
    List<BookAuthor> findBookAuthorByBook_id(String bookId);
}

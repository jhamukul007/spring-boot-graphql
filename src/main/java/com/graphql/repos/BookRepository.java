package com.graphql.repos;

import com.graphql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String > {

}

### GraphQL Configurations and Query

Dependency 
```agsl
implementation 'org.springframework.boot:spring-boot-starter-graphql'
```
Add configuration in application.yaml
```agsl
spring:
  graphql:
    graphiql:
      enabled: true
      path: /graphiql
```
### GraphQL Dashboard
```agsl
http://localhost:8080/graphiql?path=/graphql
```
### GraphQL Queries

1. Get Book By Id
```agsl
query {
  bookById(id: "5762048c-63a7-4e85-9125-bffbff18302e"){
    id
    name
  }
}
```
2. Get All Books

```agsl
query{
  getBooks{
    id
    name
  }
}
```
3. Create Book
```agsl
mutation {
  createBook(name: "A Tale of Two Cities") {
    id
    name
  }
}
```
4. Create Book Author
```agsl
mutation{
  createBookAuthor(bookId: "4950a926-914b-4eed-a887-622967d4d553"
    authorName: "Dhoni"
  ) {
    id
    book{
      id
      name
    }
    author{
      id
      name
    }
  }
}
```
5. Get Book Author by Book Id
```agsl
query{
  getBookAuthorByBookId(bookId: "4950a926-914b-4eed-a887-622967d4d553"){
    id
     book{
      id
      name
    }
    author{
      id
      name
    }
  }
}
```
6. Get All Book Author 
```agsl
query{
  getAllBookAuthor{
    id
    book{
      id
      name
    }
    author{
      id
      name
    }
  }
}
```
### H2 Database Configuration 
Dependency Require
```agsl
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'com.h2database:h2'
```
Configurations:

Database
```agsl
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    username: admin
    password: password
    driverClassName: org.h2.Driver
  jpa:
    data-platform: org.hibernate.dialect.H2Dialect
    defer-datasource-initialization: true
  h2:
    console:
      enabled: true
      path: /h2-console

```
defer-datasource-initialization used to preload table creation and data.
And file should be inside resource folder with name data.sql.

data.sql file content 

````agsl
DROP TABLE book_author;
DROP TABLE book;
DROP TABLE author;

CREATE TABLE book (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO book(id, name) VALUES ('0ab34179-3ad5-4130-a3bd-962facec601b','1984');
INSERT INTO book(id, name) VALUES ('6646f3ef-8426-45ef-abb4-9f4f72885a17','Animal Farm');
INSERT INTO book(id, name) VALUES ('f908fe8a-aa4a-4c9f-823e-10cc95c9ba20','To Kill a Mockingbird');
INSERT INTO book(id, name) VALUES ('3e809e52-bccf-4886-be37-fd5c569b0dc9','Pride and Prejudice');
INSERT INTO book(id, name) VALUES ('8c39e1f4-faed-498d-b6f4-3d831a390dfe','Sense and Sensibility');


CREATE TABLE author (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO author(id, name) VALUES ('0ab34179-3ad5-4130-a3bd-962facec601b','George Orwell');
INSERT INTO author(id, name) VALUES ('6646f3ef-8426-45ef-abb4-9f4f72885a17','Harper Lee');
INSERT INTO author(id, name) VALUES ('f908fe8a-aa4a-4c9f-823e-10cc95c9ba20','Douglas Adams');
INSERT INTO author(id, name) VALUES ('3e809e52-bccf-4886-be37-fd5c569b0dc9','Jane Austen');
INSERT INTO author(id, name) VALUES ('8c39e1f4-faed-498d-b6f4-3d831a390dfe','F. Scott Fitzgerald');


CREATE TABLE book_author (
 id VARCHAR(255) NOT NULL,
 book_id VARCHAR(255) NOT NULL,
 author_id VARCHAR(255) NOT NULL,
 PRIMARY KEY(id),
 FOREIGN KEY(book_id) REFERENCES book(id),
 FOREIGN KEY(author_id) REFERENCES author(id)
);

INSERT INTO book_author(id, book_id, author_id) VALUES ('0ab34179-3ad5-4130-a3bd-962facec601b','0ab34179-3ad5-4130-a3bd-962facec601b', '0ab34179-3ad5-4130-a3bd-962facec601b');
INSERT INTO book_author(id, book_id, author_id) VALUES ('6646f3ef-8426-45ef-abb4-9f4f72885a17','0ab34179-3ad5-4130-a3bd-962facec601b', '6646f3ef-8426-45ef-abb4-9f4f72885a17');
INSERT INTO book_author(id, book_id, author_id) VALUES ('f908fe8a-aa4a-4c9f-823e-10cc95c9ba20','0ab34179-3ad5-4130-a3bd-962facec601b', 'f908fe8a-aa4a-4c9f-823e-10cc95c9ba20');
INSERT INTO book_author(id, book_id, author_id) VALUES ('3e809e52-bccf-4886-be37-fd5c569b0dc9','3e809e52-bccf-4886-be37-fd5c569b0dc9', '3e809e52-bccf-4886-be37-fd5c569b0dc9');
INSERT INTO book_author(id, book_id, author_id) VALUES ('8c39e1f4-faed-498d-b6f4-3d831a390dfe','8c39e1f4-faed-498d-b6f4-3d831a390dfe', '8c39e1f4-faed-498d-b6f4-3d831a390dfe');
````
### H2 database console 

```agsl
http://localhost:8080/h2-console
```



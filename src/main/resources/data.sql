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


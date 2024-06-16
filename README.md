### Enable GraphQL Dashboard
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


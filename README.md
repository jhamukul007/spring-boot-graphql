### Enable GraphQL Dashboard
Add configuration in application.yaml

spring:
  graphql:
    graphiql:
      enabled: true
      path: /graphiql

### GraphQL Queries 

query {
  bookById(id: "5762048c-63a7-4e85-9125-bffbff18302e"){
    id
    name
  }
}

query{
  getBooks{
    id
    name
  }
}


mutation {
  createBook(name: "A Tale of Two Cities") {
    id
    name
  }
}

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


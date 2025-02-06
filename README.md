# JavaProjectFinal1
 Java Spring Boot project, Jona-Metin

Welcome to the Library Management System! This application allows users to manage books, library members, and their borrowing activities. The system is built using Java Spring Boot, JPA, and MySQL for backend management.

Libraries and Frameworks used:

Spring Boot: Main framework for building the backend of the application.
Spring Data JPA: Used for handling database interactions.
MySQL: Database for storing books, members, and transactions.
JUnit: For unit testing.
This README will guide you through the setup and usage of the project, including detailed information on available REST endpoints.

## Setting up the project

### Prerequisites

    Java 21
    Maven
    MySQL


## Installation

1. Clone the repository

   `git clone ---`

2. Navigate to the project directory

   `cd library-project`

3. Install the dependencies

   `mvn install`
4. Create a new MySQL database and configure the database settings in the 'application.properties' file.

5. Run the application

   `mvn spring-boot:run`

6. The application should now be running on 'http://localhost:8080/'
7. 
## Depenedencies

      Spring Boot 2.7.8
      SpringWeb
      MySQL Driver
      Spring Data JPA


## Database
*connected to phpMyAdmin
*Make sure to update the username and password fields in application.properties file with your MySQL credentials before running the application.*

## Endpoints

The following are the available REST endpoints for the _Library_ Endpoints:


`POST /libraries: Creates a new library.
GET /libraries: Returns a list of all libraries.
GET /libraries/{id}: Returns a specific library by ID.
GET /libraries/search/address: Returns a list of all libraries in a specific address.
GET /libraries/search/type: Returns a list of all libraries by a specific library type.
GET /libraries/search/name: Returns a list of all libraries matching the name.
GET /libraries/search/addressAndName: Returns a list of all libraries matching both address and name.
PUT /libraries/{id}: Updates an existing library.
DELETE /libraries/{id}: Deletes an existing library.
Member Endpoints
GET /libraries/{libraryId}/members: Returns a list of all members of a specific library.
POST /libraries/{libraryId}/members: Adds a new member to a specific library.`
 

The following are the available REST endpoints for the _Member_ Endpoints:

`POST /members: Creates a new member.
GET /members: Returns a list of all members.
GET /members/{id}: Returns a specific member by ID.
GET /members/library/{libraryId}: Returns a list of all members in a specific library.
PUT /members/{id}: Updates an existing member.
DELETE /members/{id}: Deletes an existing member by ID.
PUT /members/{memberId}/assign/{libraryId}: Assigns a member to a specific library.`


The following are the available REST endpoints for the _Book_ Endpoints:

`POST /books: Adds a new book.
GET /books: Returns a list of all books.
GET /books/{id}: Returns a specific book by ID.
PUT /books/{id}: Updates an existing book.
DELETE /books/{id}: Deletes a book by ID.
GET /books/search: Searches for books by title, author, or category (all parameters are optional).`

The following are the available REST endpoints for the _Category_ Endpoints:

`POST /categories: Creates a new category.
GET /categories: Returns a list of all categories.
GET /categories/{id}: Returns a specific category by ID.
GET /categories/search: Returns a category by name.
PUT /categories/{id}: Updates an existing category.
DELETE /categories/{id}: Deletes a category by ID.`

The following are the available REST endpoints for the _Transaction_ Endpoints:

`GET /transactions/member/{memberId}: Returns a list of all transactions by a specific member.
GET /transactions/book/{bookId}: Returns a list of all transactions by a specific book.
POST /transactions/{memberId}/member/{bookId}/book: Creates a new transaction, ensuring the memberId and bookId in the URL match the ones in the transaction.
GET /transactions/{id}: Returns a specific transaction by ID.
PUT /transactions/{id}: Updates an existing transaction (e.g., changing the status).`

## examples 

### GET /libraries
http://localhost:8080/libraries

   `[
    {
        "id": 1,
        "name": "City Library",
        "address": "STRUGA",
        "type": "PUBLIC",
        "latitude": 41.1234,
        "longitude": 20.8012,
        "members": [
            {
                "id": 3,
                "name": "Metin Memeti",
                "email": "metin@example.com",
                "phone": "+222222222",
                "membershipDate": "2022-02-21",
                "transactions": []
            }
        ],
        "books": []
    },
    {
        "id": 2,
        "name": "Nobel",
        "address": "TETOVO",
        "type": "SPECIAL",
        "latitude": 41.1234,
        "longitude": 20.8012,
        "members": [
            {
                "id": 2,
                "name": "Jona Sela",
                "email": "js30873@example.com",
                "phone": "+111111111",
                "membershipDate": "2025-01-11",
                "transactions": [
                    {
                        "id": 1,
                        "borrowDate": "2025-02-01",
                        "returnDate": "2025-02-10",
                        "status": "BORROWED"
                    }
                ]
            }
        ],
        "books": [
            {
                "id": 1,
                "title": "The Great Gatsby",
                "author": "F. Scott Fitzgerald"
            },
            {
                "id": 3,
                "title": "Heart&Bones",
                "author": "Katherine"
            }
        ]
    },
    {
        "id": 3,
        "name": "Creativity",
        "address": "STRUGA",
        "type": "SPECIAL",
        "latitude": 41.777,
        "longitude": 20.8012,
        "members": [],
        "books": [
            {
                "id": 2,
                "title": "Before we were Strangers",
                "author": "Renee Carlino"
            }
        ]
    },
    {
        "id": 4,
        "name": "STELLA",
        "address": "STRUGA",
        "type": "NATIONAL",
        "latitude": 11.777,
        "longitude": 20.8012,
        "members": [],
        "books": []
    }
]`




## Notes

      Make sure you configure your application.properties accordingly to your own setup.
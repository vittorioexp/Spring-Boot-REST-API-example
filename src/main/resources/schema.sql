CREATE TABLE category(
    id_category SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE book(
    id_book SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    release_date DATE NOT NULL,
    isbn VARCHAR(20),
    id_category INT NOT NULL,
    FOREIGN KEY (id_category) REFERENCES category (id_category),
    images VARCHAR(100)
);

CREATE TABLE user(
    id_user SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    isbn VARCHAR(20),
    picture VARCHAR(100)
);
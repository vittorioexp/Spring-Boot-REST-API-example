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

CREATE TABLE customer(
    id_customer SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    isbn VARCHAR(20),
    picture VARCHAR(100)
);

CREATE TABLE reading (
    id_reading SERIAL PRIMARY KEY,
    id_customer INT NOT NULL,
    id_book INT NOT NULL,
    date DATE NOT NULL,
    state VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer (id_customer),
    FOREIGN KEY (id_book) REFERENCES book (id_book)
);

CREATE TABLE feedback (
    id_feedback SERIAL PRIMARY KEY,
    id_customer INT NOT NULL,
    id_book INT NOT NULL,
    rate INT NOT NULL,
    text VARCHAR(10000),
    date DATE NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer (id_customer),
    FOREIGN KEY (id_book) REFERENCES book (id_book)
);
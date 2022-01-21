INSERT INTO category (id_category, name) VALUES
(1, 'Entrepreneurship'),
(2, 'Science'),
(3, 'Economics'),
(4, 'Investments'),
(5, 'Relationships'),
(6, 'Parenting'),
(7, 'Philosophy'),
(8, 'Culture'),
(9, 'Politics'),
(10, 'Nutrition'),
(11, 'History'),
(12, 'Management'),
(13, 'Psychology');


INSERT INTO book (id_book, title, author, release_date, isbn, id_category, images) VALUES
    (1, 'Blitzscaling', 'Reid Hoffman', '2021-09-19', '987654321', 1, 'https://images-na.ssl-images-amazon.com/images/I/81t-86ISGuL.jpg');

INSERT INTO book (id_book, title, author, release_date, isbn, id_category, images) VALUES
    (2, 'Company of One', 'Paul Jarvis', '2021-09-20', '987654311', 1, 'https://m.media-amazon.com/images/I/41Rz8Me31NL.jpg');

INSERT INTO book (id_book, title, author, release_date, isbn, id_category, images) VALUES
    (3, 'Cooking up a business', 'David Cohen and Brad Feld', '2021-09-18', '987654211', 1, 'https://m.media-amazon.com/images/I/519wTAlmTCL.jpg');

INSERT INTO book (id_book, title, author, release_date, isbn, id_category, images) VALUES
    (4, 'Breakpoint', 'Jeff Stibel', '2021-09-18', '947654211', 2, 'https://images-na.ssl-images-amazon.com/images/I/51B4-igcYsL._AC_UL600_SR600,600_.jpg');

INSERT INTO book (id_book, title, author, release_date, isbn, id_category, images) VALUES
    (5, 'Conscious', 'Annaka Harris', '2021-09-17', '947354211', 2, 'https://images-na.ssl-images-amazon.com/images/I/91Oy00Se3YL.jpg');

INSERT INTO customer (id_customer, username, email, password, picture)VALUES
    (1, 'vittorioexp', 'vittorioexp@fakeemail.it', '123456789A', 'https://images.unsplash.com/photo-1508138221679-760a23a2285b');

INSERT INTO customer (id_customer, username, email, password, picture) VALUES
    (2, 'samuperti', 'samuperti@fakeemail.it', 'ssssssssqqqA', 'https://images.unsplash.com/photo-1508138221679-760a23a2285b');

INSERT INTO customer (id_customer, username, email, password, picture) VALUES
    (3, 'adamsmith', 'adamsmith@adamsmith.it', 'adamsmithadamsmith', 'https://images.unsplash.com/photo-1508138221679-760a23a2285b');

INSERT INTO reading (id_reading, id_customer, id_book, date, state)VALUES
    (1, 1, 2, '2021-08-20', 'COMPLETED');

INSERT INTO reading (id_reading, id_customer, id_book, date, state)VALUES
    (2, 1, 2, '2021-07-20', 'COMPLETED');

INSERT INTO reading (id_reading, id_customer, id_book, date, state)VALUES
    (3, 2, 4, '2021-09-20', 'COMPLETED');

INSERT INTO reading (id_reading, id_customer, id_book, date, state)VALUES
    (4, 2, 5, '2021-09-29', 'COMPLETED');

INSERT INTO feedback (id_feedback, id_customer, id_book, rate, text, date) VALUES
    (1, 1, 1, 3, 'not that interesting...', '2021-09-22');

INSERT INTO feedback (id_feedback, id_customer, id_book, rate, text, date) VALUES
    (2, 1, 2, 5, 'Super cool!', '2021-09-22');

INSERT INTO feedback (id_feedback, id_customer, id_book, rate, text, date) VALUES
    (3, 2, 5, 3, 'Ok!', '2021-09-22');
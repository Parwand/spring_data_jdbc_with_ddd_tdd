DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS author_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;


CREATE TABLE pets(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE
);

CREATE TABLE person(
    id BIGINT AUTO_INCREMENT primary key,
    name VARCHAR(50)
);

CREATE TABLE address(
    street VARCHAR(250),
    plz BIGINT,
    country VARCHAR(250),
    person BIGINT,
    CONSTRAINT id_foreign_key FOREIGN KEY (person) REFERENCES person(id)
                                  ON DELETE CASCADE
                                  ON UPDATE CASCADE
);

CREATE TABLE author(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250)
);

CREATE TABLE book(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250),
    isbn VARCHAR(250),
    text text
);

CREATE TABLE author_book(
    author BIGINT,
    book BIGINT,
    CONSTRAINT pk_author_book PRIMARY KEY (author, book)
);

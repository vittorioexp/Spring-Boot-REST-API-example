package com.example.randombook.book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Optional<Book> findById(int id);
    List<Book> findAll();
    List<Book> findAllByCategory(int id_category);
    Optional<Book> findRandomBook(int id_category);
    Book create(Book book);
    Book update(Book book, int id);
    void delete(int id_book);
    long count();
}
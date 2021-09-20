package com.example.randombook.book;

import com.example.randombook.category.*;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Optional<Book> findById(int id);
    List<Book> findAll();
    List<Book> findAllByCategory(Category category);
    Book create(Book book);
    Book update(Book book);
    void delete(int id_book);
    long count();
}
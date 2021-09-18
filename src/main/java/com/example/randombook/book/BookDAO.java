package com.example.randombook.book;

import com.example.randombook.category.*;

import java.util.List;

public interface BookDAO {
    Book findById(int id_book);
    List<Book> findAll();
    List<Book> findAllByCategory(Category category);
    Book create(Book book);
    Book update(Book book);
    void delete(int id_book);
    long count();
}
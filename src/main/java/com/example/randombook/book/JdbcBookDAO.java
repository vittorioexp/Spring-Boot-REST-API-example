package com.example.randombook.book;

import org.springframework.stereotype.Repository;
import com.example.randombook.category.*;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBookDAO implements BookDAO {


    @Override
    public Book findById(int id_book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(int id_book) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Book> findAllByCategory(Category category) {
        return null;
    }
}

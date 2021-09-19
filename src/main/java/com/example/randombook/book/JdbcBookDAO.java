package com.example.randombook.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.example.randombook.category.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcBookDAO implements BookDAO {

    private List<Book> books;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertBook;

    public JdbcBookDAO(JdbcTemplate jdbcTemplate) {
        this.books = new ArrayList<Book>();
        this.jdbcTemplate = jdbcTemplate;
        insertBook = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("book")
                .usingGeneratedKeyColumns("id_book");
    }

    RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Category category = new Category(
                rs.getInt("id_category"),
                ""
        );
        Book book = new Book(
                rs.getInt("id_book"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDate("release_date"),
                rs.getString("isbn"),
                category,
                rs.getString("images")
        );
        return book;
    };

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




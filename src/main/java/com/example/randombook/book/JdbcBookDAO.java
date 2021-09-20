package com.example.randombook.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.example.randombook.category.*;

import java.util.*;

@Repository
public class JdbcBookDAO implements BookDAO {

    private List<Book> books;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertBook;

    public JdbcBookDAO(JdbcTemplate jdbcTemplate) {
        this.books = new ArrayList<>();
        this.jdbcTemplate = jdbcTemplate;
        insertBook = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("book")
                .usingGeneratedKeyColumns("id_book");
    }

    RowMapper<Book> rowMapper = (rs, rowNum) -> {
        int id_category = rs.getInt("id_category");
        Category category = new Category(
                id_category,
                ""
        );
        return new Book(
                rs.getInt("id_book"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDate("release_date"),
                rs.getString("isbn"),
                category,
                rs.getString("images")
        );
    };

    @Override
    public Optional<Book> findById(int id) {
        String sql = "SELECT * FROM book where id_book = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Book> findAllByCategory(Category category) {
        return null;
    }

    @Override
    public Book create(Book book) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("title", book.getTitle());
        parameters.put("author", book.getAuthor());
        parameters.put("releaseDate", book.getReleaseDate());
        parameters.put("isbn", book.getIsbn());
        parameters.put("category", book.getCategory());
        parameters.put("images", book.getImages());
        Number id_book = insertBook.executeAndReturnKey(parameters);
        return new Book(
                (Integer) id_book,
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseDate(),
                book.getIsbn(),
                book.getCategory(),
                book.getImages()
        );
    }

    @Override
    public Book update(Book book) {
        String sql = "update book set title = ?, " +
                "author = ?, release_date = ?, " +
                "isbn = ?, id_category = ?, " +
                "images = ? where id_book = ?";
        Book b = new Book(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseDate(),
                book.getIsbn(),
                book.getCategory(),
                book.getImages()
        );
        jdbcTemplate.update(
                sql,
                b.getTitle(),
                b.getAuthor(),
                b.getReleaseDate(),
                b.getIsbn(),
                b.getCategory().getId(),
                b.getImages(),
                b.getId()
        );
        return b;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from book where id_book = ?",id);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from book", Long.class);
    }
}




package com.example.randombook.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final JdbcBookDAO dao;

    public BookController(JdbcBookDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Book> findAll() {
        return dao.findAll();
    }

    @GetMapping("/category/{id_category}")
    public List<Book> findAllByCategory(@PathVariable int id_category) {
        return dao.findAllByCategory(id_category);
    }

    @GetMapping("/random")
    public Optional<Book> findRandomBook(@RequestParam(value = "category", defaultValue = "0") int id_category) {
        return dao.findRandomBook(id_category);
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(@RequestBody Book book) {
        return dao.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable int id) {
        return dao.update(book, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

}

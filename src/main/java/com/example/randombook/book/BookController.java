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

    /**
     * Gets all books.
     *
     * @return the list of books
     */
    @GetMapping
    public List<Book> findAll() {
        return dao.findAll();
    }

    /**
     * Gets books by category ID.
     *
     * @param id_category the category ID
     * @return the books by category ID
     */
    @GetMapping("/category/{id_category}")
    public List<Book> findAllByCategory(@PathVariable int id_category) {
        return dao.findAllByCategory(id_category);
    }

    /**
     * Gets a random book, optionally by category
     *
     * @param id_category the category ID
     * @return a random book by category ID
     */
    @GetMapping("/random")
    public Optional<Book> findRandomBook(@RequestParam(value = "category", defaultValue = "0") int id_category) {
        return dao.findRandomBook(id_category);
    }

    /**
     * Gets a book by ID
     *
     * @param id the book ID
     * @return a book having the given ID
     */
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    /**
     * Creates a book
     *
     * @param book the book to be created
     * @return the just created book
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(@RequestBody Book book) {
        return dao.create(book);
    }

    /**
     * Updates a book
     *
     * @param book the book to be updated
     * @param id the ID of the book to be updated
     * @return the just updated book
     */
    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable int id) {
        return dao.update(book, id);
    }

    /**
     * Deletes a book
     *
     * @param id the ID of the book to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

}

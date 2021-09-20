package com.example.randombook.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final JdbcCategoryDAO dao;

    public CategoryController(JdbcCategoryDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Category> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Category create(@RequestBody Category category) {
        return dao.create(category);
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable int id) {
        return dao.update(category, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

}

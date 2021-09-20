package com.example.randombook.user;

import com.example.randombook.category.Category;
import com.example.randombook.category.JdbcCategoryDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final JdbcUserDAO dao;

    public UserController(JdbcUserDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<User> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        return dao.create(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        return dao.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}

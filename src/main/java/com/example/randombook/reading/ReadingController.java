package com.example.randombook.reading;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reading")
public class ReadingController {

    private final JdbcReadingDAO dao;

    public ReadingController(JdbcReadingDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Reading> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reading> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Reading> findAllByCustomerId(@PathVariable int id) {
        return dao.findAllByCustomerId(id);
    }

    @GetMapping("/book/{id}")
    public List<Reading> findAllByBookId(@PathVariable int id) {
        return dao.findAllByBookId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Reading create(@RequestBody Reading reading) {
        return dao.create(reading);
    }

    @PutMapping("/{id}")
    public Reading update(@RequestBody Reading reading, @PathVariable int id) {
        return dao.update(reading, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

}

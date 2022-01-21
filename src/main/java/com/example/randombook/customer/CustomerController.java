package com.example.randombook.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final JdbcCustomerDAO dao;

    public CustomerController(JdbcCustomerDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Customer> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable int id) {
        return dao.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return dao.create(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id) {
        return dao.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}

package com.example.randombook.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    List<Customer> findAll();
    Optional<Customer> findById(int id);
    Customer create(Customer customer);
    Customer update(Customer customer, int id);
    void delete(int id);
    long count();
}

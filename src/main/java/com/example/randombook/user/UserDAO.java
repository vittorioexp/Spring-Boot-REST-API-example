package com.example.randombook.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();
    Optional<User> findById(int id);
    User create(User user);
    User update(User user, int id);
    void delete(int id);
    long count();
}

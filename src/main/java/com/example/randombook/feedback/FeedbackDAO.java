package com.example.randombook.feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackDAO {
    Optional<Feedback> findById(int id);
    List<Feedback> findAll();
    List<Feedback> findAllByCustomerId(int id_customer);
    List<Feedback> findAllByBookId(int id_book);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback, int id);
    void delete(int id_feedback);
    long count();
}

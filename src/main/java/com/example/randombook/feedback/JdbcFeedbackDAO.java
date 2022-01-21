package com.example.randombook.feedback;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcFeedbackDAO implements FeedbackDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertFeedback;

    public JdbcFeedbackDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertFeedback = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("feedback")
                .usingGeneratedKeyColumns("id_feedback");
    }

    RowMapper<Feedback> rowMapper = (rs, rowNum) -> new Feedback(
            rs.getInt("id_feedback"),
            rs.getInt("id_customer"),
            rs.getInt("id_book"),
            rs.getInt("rate"),
            rs.getString("text"),
            rs.getDate("date")
    );

    @Override
    public Optional<Feedback> findById(int id) {
        String sql = "SELECT * FROM feedback where id_feedback = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public List<Feedback> findAll() {
        String sql = "SELECT * FROM feedback";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Feedback> findAllByCustomerId(int id_customer) {
        String sql = "SELECT * FROM feedback where id_customer = ?";
        return jdbcTemplate.query(sql, rowMapper, id_customer);
    }

    @Override
    public List<Feedback> findAllByBookId(int id_book) {
        String sql = "SELECT * FROM feedback where id_book = ?";
        return jdbcTemplate.query(sql, rowMapper, id_book);
    }

    @Override
    public Feedback create(Feedback feedback) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("id_customer", feedback.getCustomer());
        parameters.put("id_book", feedback.getBook());
        parameters.put("rate", feedback.getRate());
        parameters.put("text", feedback.getText());
        parameters.put("date", feedback.getDate());
        Number id_feedback = insertFeedback.executeAndReturnKey(parameters);
        return new Feedback(
                (Integer) id_feedback,
                feedback.getCustomer(),
                feedback.getBook(),
                feedback.getRate(),
                feedback.getText(),
                feedback.getDate()
        );
    }

    @Override
    public Feedback update(Feedback feedback, int id) {
        String sql = "update feedback set " +
                "id_customer = ?," +
                "id_book = ?, rate = ?," +
                "text = ?, date = ? " +
                "where id_feedback = ?";
        Feedback f = new Feedback(
                id,
                feedback.getCustomer(),
                feedback.getBook(),
                feedback.getRate(),
                feedback.getText(),
                feedback.getDate()
        );
        jdbcTemplate.update(
                sql,
                f.getCustomer(),
                f.getBook(),
                f.getRate(),
                f.getText(),
                f.getDate(),
                f.getId()
        );
        return f;
    }

    @Override
    public void delete(int id_feedback) {
        jdbcTemplate.update("delete from feedback where id_feedback = ?", id_feedback);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from feedback", Long.class);
    }
}

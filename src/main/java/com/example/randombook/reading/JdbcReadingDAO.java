package com.example.randombook.reading;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcReadingDAO implements ReadingDAO{

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertReading;

    public JdbcReadingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertReading = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("reading")
                .usingGeneratedKeyColumns("id_reading");
    }

    RowMapper<Reading> rowMapper = (rs, rowNum) -> new Reading(
            rs.getInt("id_reading"),
            rs.getInt("id_customer"),
            rs.getInt("id_book"),
            rs.getDate("date"),
            rs.getString("state")
    );

    @Override
    public List<Reading> findAll() {
        String sql = "SELECT * FROM reading";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Reading> findById(int id_reading) {
        String sql = "SELECT * FROM reading where id_reading = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id_reading));
    }

    @Override
    public List<Reading> findAllByCustomerId(int id_customer) {
        String sql = "SELECT * FROM reading where id_customer = ?";
        return jdbcTemplate.query(sql, rowMapper, id_customer);
    }

    @Override
    public List<Reading> findAllByBookId(int id_book) {
        String sql = "SELECT * FROM reading where id_book = ?";
        return jdbcTemplate.query(sql, rowMapper, id_book);
    }

    @Override
    public Reading create(Reading reading) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("id_customer", reading.getCustomer());
        parameters.put("id_book", reading.getBook());
        parameters.put("date", reading.getDate());
        parameters.put("state", reading.getState());
        Number id_reading = insertReading.executeAndReturnKey(parameters);
        return new Reading(
                (Integer) id_reading,
                reading.getCustomer(),
                reading.getBook(),
                reading.getDate(),
                reading.getState()
        );
    }

    @Override
    public Reading update(Reading reading, int id_reading) {
        String sql = "update reading set id_customer = ?, " +
                "id_book = ?, date = ?, " +
                "state = ? where id_reading = ?";
        Reading r = new Reading(
                id_reading,
                reading.getCustomer(),
                reading.getBook(),
                reading.getDate(),
                reading.getState()
        );
        jdbcTemplate.update(
                sql,
                r.getCustomer(),
                r.getBook(),
                r.getDate(),
                r.getState(),
                r.getId()
        );
        return r;
    }

    @Override
    public void delete(int id_reading) {
        jdbcTemplate.update("delete from reading where id_reading = ?",id_reading);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from reading", Long.class);
    }
}

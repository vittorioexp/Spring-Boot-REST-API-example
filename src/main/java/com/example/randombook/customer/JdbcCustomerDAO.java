package com.example.randombook.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JdbcCustomerDAO implements CustomerDAO {

    private final List<Customer> customers;
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertCustomer;

    public JdbcCustomerDAO(JdbcTemplate jdbcTemplate) {
        this.customers = new ArrayList<>();
        this.jdbcTemplate = jdbcTemplate;
        insertCustomer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("customer")
                .usingGeneratedKeyColumns("id_customer");
    }

    RowMapper<Customer> rowMapper = (rs, rowNum) -> {
        return new Customer(
                rs.getInt("id_customer"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("picture")
        );
    };

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM \"customer\"";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Customer> findById(int id) {
        String sql = "SELECT * FROM \"customer\" where id_customer = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public Customer create(Customer customer) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("username", customer.getUsername());
        parameters.put("email", customer.getEmail());
        parameters.put("password", customer.getPassword()); // Password should be encrypted
        parameters.put("picture", customer.getPicture());
        Number id_customer = insertCustomer.executeAndReturnKey(parameters);
        return new Customer(
                (Integer) id_customer,
                customer.getUsername(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPicture()
        );
    }

    @Override
    public Customer update(Customer customer, int id) {
        String sql = "update \"customer\" set username = ?, " +
                "email = ?, password = ?, " +
                "picture = ? where id_customer = ?";
        Customer u = new Customer(
                id,
                customer.getUsername(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPicture()
        );
        jdbcTemplate.update(
                sql,
                u.getUsername(),
                u.getEmail(),
                u.getPassword(),
                u.getPicture(),
                u.getId()
        );
        return u;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from \"customer\" where id_customer = ?",id);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from \"customer\"", Long.class);
    }
}

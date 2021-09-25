package com.example.randombook.user;

import com.example.randombook.book.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JdbcUserDAO implements UserDAO {

    private final List<User> users;
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertUser;

    public JdbcUserDAO(JdbcTemplate jdbcTemplate) {
        this.users = new ArrayList<>();
        this.jdbcTemplate = jdbcTemplate;
        insertUser = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user")
                .usingGeneratedKeyColumns("id_user");
    }

    RowMapper<User> rowMapper = (rs, rowNum) -> {
        return new User(
                rs.getInt("id_user"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("picture")
        );
    };

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM \"user\"";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM \"user\" where id_user = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public User create(User user) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword()); // Password should be encrypted
        parameters.put("picture", user.getPicture());
        Number id_user = insertUser.executeAndReturnKey(parameters);
        return new User(
                (Integer) id_user,
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getPicture()
        );
    }

    @Override
    public User update(User user, int id) {
        String sql = "update \"user\" set username = ?, " +
                "email = ?, password = ?, " +
                "picture = ? where id_user = ?";
        User u = new User(
                id,
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getPicture()
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
        jdbcTemplate.update("delete from \"user\" where id_user = ?",id);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from \"user\"", Long.class);
    }
}

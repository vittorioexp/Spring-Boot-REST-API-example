package com.example.randombook.category;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class JdbcCategoryDAO implements CategoryDAO {

    private List<Category> categories;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertCategory;

    public JdbcCategoryDAO(JdbcTemplate jdbcTemplate) {
        this.categories = new ArrayList<Category>();
        this.jdbcTemplate = jdbcTemplate;
        insertCategory = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("category")
                .usingGeneratedKeyColumns("id_category");
    }

    RowMapper<Category> rowMapper = (rs, rowNum) -> {
        Category c = new Category(
                rs.getInt("id_category"),
                rs.getString("name")
        );
        return c;
    };

    @Override
    public Optional<Category> findById(int id) {
        String sql = "SELECT * FROM category where id_category = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from category where id_category = ?", id);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from category", Long.class);
    }

    @Override
    public Category update(Category category) {
        String sql = "update category set name = ? where id_category = ?";
        Category c = new Category(
                category.getId(),
                category.getName()
        );
        jdbcTemplate.update(
                sql,
                c.getName(),
                c.getId()
        );
        return c;
    }

    @Override
    public Category create(Category category) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("name", category.getName());
        Number id_category = insertCategory.executeAndReturnKey(parameters);
        return new Category(
                (Integer) id_category,
                category.getName()
        );
    }
}

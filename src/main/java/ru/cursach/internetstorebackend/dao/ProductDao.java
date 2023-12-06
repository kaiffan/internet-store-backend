package ru.cursach.internetstorebackend.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    private final NamedParameterJdbcTemplate template;

    public ProductDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
}

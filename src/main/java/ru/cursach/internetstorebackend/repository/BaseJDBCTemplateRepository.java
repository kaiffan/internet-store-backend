package ru.cursach.internetstorebackend.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.cursach.internetstorebackend.annotation.Table;
import ru.cursach.internetstorebackend.domain.entity.Entity;

public abstract class BaseJDBCTemplateRepository<TEntity extends Entity> {
    protected JdbcTemplate jdbcTemplate;
    protected String tableName;

    public BaseJDBCTemplateRepository(JdbcTemplate jdbcTemplate, Class<TEntity> entityClass) {
        this.jdbcTemplate = jdbcTemplate;
        tableName = entityClass.getAnnotation(Table.class).name();
    }
}

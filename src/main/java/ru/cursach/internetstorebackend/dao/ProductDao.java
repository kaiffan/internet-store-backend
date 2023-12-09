package ru.cursach.internetstorebackend.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Repository
public class ProductDao {
    private final NamedParameterJdbcTemplate template;

    public ProductDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void getProductById(UUID id_product) {
        String sql = "select * from product where code_product = :id_product";
        template.execute(sql, new PreparedStatementCallback<Object>() {
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}

package ru.cursach.internetstorebackend.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;
import ru.cursach.internetstorebackend.domain.entity.Dimensions;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.DimensionsRepository;

import java.util.UUID;

@Repository
public class DimensionsRepositoryImpl extends BaseJDBCTemplateRepository<Dimensions> implements DimensionsRepository {

    public DimensionsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Dimensions.class);
    }

    @Override
    public UUID insertDimensionForProduct(DimensionsDTO dimensions) {
        UUID idDimension = UUID.randomUUID();
        String sql = "insert into dimensions " +
                "values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                idDimension,
                dimensions.getLength(),
                dimensions.getWidth(),
                dimensions.getHeight(),
                dimensions.getWeight());
        return idDimension;

    }
}

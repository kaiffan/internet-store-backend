package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.entity.Manufacturer;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.ManufacturerRepository;

import java.util.List;

@Repository
public class ManufacturerRepositoryImpl extends BaseJDBCTemplateRepository<Manufacturer> implements ManufacturerRepository {
    public ManufacturerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Manufacturer.class);
    }

    @Override
    public List<Manufacturer> getAllManufacturer() {
        String sql = " select id, name from manufacturer";

        ResultSetExtractor<List<Manufacturer>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(Manufacturer.class);

        return jdbcTemplate.query(sql, mapper);
    }
}

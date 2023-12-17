package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.entity.Country;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CountryRepository;

import java.util.List;

@Repository
public class CountryRepositoryImpl extends BaseJDBCTemplateRepository<Country> implements CountryRepository {

    public CountryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Country.class);
    }

    @Override
    public List<Country> getAllCountries() {
        String sql = "select id, name from country";

        ResultSetExtractor<List<Country>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(Country.class);
        return jdbcTemplate.query(sql, mapper);
    }
}

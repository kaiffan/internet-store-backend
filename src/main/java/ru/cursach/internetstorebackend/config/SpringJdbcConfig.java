package ru.cursach.internetstorebackend.config;

import org.noear.weed.DbContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {
    @Bean
    public DbContext dbContext(DataSource dataSource){
        return new DbContext("internet_store", dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}

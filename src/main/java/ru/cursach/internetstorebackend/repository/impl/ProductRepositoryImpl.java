package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.ProductShortDTO;
import ru.cursach.internetstorebackend.domain.entity.Product;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.ProductRepository;

import java.util.List;

@Repository
public class ProductRepositoryImpl extends BaseJDBCTemplateRepository<Product> implements ProductRepository {
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Product.class);
    }

    @Override
    public List<ProductShortDTO> getAllProductShortDTOBySubcategory(int idSubcategory, int limit, int offset) {
        String sql = "select code_product, name, description, image, raiting, 200 as price_price" +
                " from product " +
                " where product.id_subcategory = " + idSubcategory;
        //TODO:неправильный вариант, надо обдумать, ошибка с price_price

        ResultSetExtractor<List<ProductShortDTO>> mapper = JdbcTemplateMapperFactory
                .newInstance()
                .newResultSetExtractor(ProductShortDTO.class);
        return jdbcTemplate.query(sql, mapper);
    }
}

package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.entity.Category;
import ru.cursach.internetstorebackend.domain.entity.Subcategory;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl extends BaseJDBCTemplateRepository<Category> implements CategoryRepository {
    public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Category.class);
    }

    @Override
    public List<CatalogueDTO> getAllCategoriesWithSubcategories() {
        String sql = "SELECT category.id, category.title, " +
                        "subcategory.id AS subcategories_id, subcategory.title AS subcategories_title " +
                        "FROM category " +
                        "LEFT JOIN subcategory ON subcategory.parent_category = category.id " +
                        "ORDER BY id";

//        String sql = "SELECT c1.id, c1.title, " +
//                        "c2.id AS subcategories_id, c2.title AS subcategories_title " +
//                        "FROM category c1 " +
//                        "INNER JOIN category c2 ON c2.parent_category = c1.id ";

        ResultSetExtractor<List<CatalogueDTO>> extractor = JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("id", "subcategories_id")
                .newResultSetExtractor(CatalogueDTO.class);

        return jdbcTemplate.query(sql, extractor);
    }

    @Nullable
    @Override
    public Optional<String> getTitleById(int idSubcategory) {
        String sql = "select title from subcategory where id = " + idSubcategory;
        RowMapper<Subcategory> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Subcategory.class);
        List<Subcategory> subcategoryList = jdbcTemplate.query(sql, mapper);
        if (!subcategoryList.isEmpty()) {
            return Optional.of(subcategoryList.get(0).getTitle());
        }
        return Optional.empty();
    }


}

package ru.cursach.internetstorebackend.repository.impl;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;
import ru.cursach.internetstorebackend.domain.entity.Category;
import ru.cursach.internetstorebackend.domain.entity.Subcategory;
import ru.cursach.internetstorebackend.repository.BaseJDBCTemplateRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl extends BaseJDBCTemplateRepository<Category> implements CategoryRepository {
    public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, Category.class);
    }

    @Override
    public List<CatalogueDTO> getAllCategoriesWithSubcategories() {
        String sql = "SELECT id, title, subcategory_id as subcategories_id, subcategory_title as subcategories_title" +
                " from get_all_categories_with_subcategories()";

        ResultSetExtractor<List<CatalogueDTO>> extractor = JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("id", "subcategories_id")
                .newResultSetExtractor(CatalogueDTO.class);

        return jdbcTemplate.query(sql, extractor);
    }

    @Nullable
    @Override
    public Optional<String> getTitleById(
            int idSubcategory
    ) {
        String sql = "select title from get_title_subcategory(" + idSubcategory + ")";
        RowMapper<Subcategory> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Subcategory.class);
        List<Subcategory> subcategoryList = jdbcTemplate.query(sql, mapper);
        if (!subcategoryList.isEmpty()) {
            return Optional.of(subcategoryList.get(0).getTitle());
        }
        return Optional.empty();
    }

    @Override
    public UUID insertNewProductInSubCategory(
            int idSubcategory,
            ProductCreateDTO productCreateDTO,
            UUID idDimensions
    ) {
        UUID codeProduct = UUID.randomUUID();
        String sql = "call insert_product_in_new_subcategory(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                codeProduct,
                productCreateDTO.getName(),
                productCreateDTO.getDescription(),
                productCreateDTO.getImage(),
                productCreateDTO.getModel(),
                productCreateDTO.getCode_manufacturer(),
                productCreateDTO.getWarranty(),
                productCreateDTO.getIdCountry(),
                idSubcategory,
                productCreateDTO.getIdManufacturer(),
                idDimensions,
                productCreateDTO.getRaiting()
        );
        return codeProduct;
    }


}

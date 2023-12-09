package ru.cursach.internetstorebackend.repository.impl;

import org.noear.weed.DbContext;
import org.springframework.stereotype.Repository;
import ru.cursach.internetstorebackend.annotation.Table;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.entity.Category;
import ru.cursach.internetstorebackend.domain.entity.Subcategory;
import ru.cursach.internetstorebackend.repository.BaseWeed3Repository;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepositoryImpl extends BaseWeed3Repository<Category> implements CategoryRepository {
    public CategoryRepositoryImpl(DbContext dbContext) {
        super(dbContext, Category.class);
    }

    @Override
    public List<Category> getAllCategories() {
        try {
            return db.table(tableName).select("*").getList(Category.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CatalogueDTO> getAllCategoriesWithSubcategories() {
        try {

            String subcategoryTbName = Subcategory.class.getAnnotation(Table.class).name();

            var query = db.table(tableName)
                    .leftJoin(subcategoryTbName).on(tableName + ".id = " + subcategoryTbName + ".parent_category")
                    .select("*");

            return query.getList(CatalogueDTO.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

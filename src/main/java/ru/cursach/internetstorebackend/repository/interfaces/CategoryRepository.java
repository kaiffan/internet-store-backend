package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAllCategories();
    List<CatalogueDTO> getAllCategoriesWithSubcategories();
}

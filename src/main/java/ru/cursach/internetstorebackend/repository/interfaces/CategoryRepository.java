package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<CatalogueDTO> getAllCategoriesWithSubcategories();

    Optional<String> getTitleById(int idSubcategory);
}

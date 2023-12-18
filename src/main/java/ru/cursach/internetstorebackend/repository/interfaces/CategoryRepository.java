package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    List<CatalogueDTO> getAllCategoriesWithSubcategories();

    Optional<String> getTitleById(int idSubcategory);

    UUID insertNewProductInSubCategory(int idSubcategory, ProductCreateDTO productCreateDTO, UUID idDimensions);
}

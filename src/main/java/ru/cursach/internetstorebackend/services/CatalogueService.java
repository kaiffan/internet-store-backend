package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.dto.ProductShortDTO;
import ru.cursach.internetstorebackend.domain.dto.SubcategoryWithProductsDTO;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;
import ru.cursach.internetstorebackend.repository.interfaces.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogueService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    public List<CatalogueDTO> getCatalogue(){
        return categoryRepository.getAllCategoriesWithSubcategories();
    }

    public SubcategoryWithProductsDTO getSubcategoryWithProductsDTO(int idSubcategory, int limit, int offset) throws NotFoundException {
        Optional<String> subcategoryTitle = categoryRepository.getTitleById(idSubcategory);
        List<ProductShortDTO> products = productRepository.getAllProductShortDTOBySubcategory(idSubcategory, limit, offset);
        if (subcategoryTitle.isEmpty()) {
            throw new NotFoundException("Название подкатегории отсутствует");
        }
        return new SubcategoryWithProductsDTO(idSubcategory, subcategoryTitle.get(), products);
    }
}

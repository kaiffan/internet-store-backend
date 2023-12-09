package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CatalogueService {

    CategoryRepository categoryRepository;

    public List<CatalogueDTO> getCatalogue(){
        return categoryRepository.getAllCategoriesWithSubcategories();
    }
}

package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductShortDTO;
import ru.cursach.internetstorebackend.domain.dto.SubcategoryWithProductsDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.repository.interfaces.CategoryRepository;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;
import ru.cursach.internetstorebackend.repository.interfaces.DimensionsRepository;
import ru.cursach.internetstorebackend.repository.interfaces.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CatalogueService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    DimensionsRepository dimensionsRepository;
    CharacteristicRepository characteristicRepository;

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

    public UUID insertProductBySubcategory(
            int idSubcategory,
            ProductCreateDTO productCreateDTO
    ) {
        List<CharacteristicDTO> characteristics = productCreateDTO.getCharacteristics();

//        if(characteristics.isEmpty()) {
//            throw new IllegalArgumentException("Массив характеристик пуст");
//        }

        UUID dimensionsUUID = dimensionsRepository.insertDimensionForProduct(productCreateDTO.getDimensions());
        UUID codeProduct = categoryRepository.insertNewProductInSubCategory(idSubcategory, productCreateDTO, dimensionsUUID);

        for(CharacteristicDTO characteristicDTO : characteristics) {
            characteristicRepository.insertCharacteristicByProduct(characteristicDTO, codeProduct);
        }

        return codeProduct;
    }
}

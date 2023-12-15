package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.ProductShortDTO;

import java.util.List;

public interface ProductRepository {
    List<ProductShortDTO> getAllProductShortDTOBySubcategory(int idSubcategory, int limit, int offset);
}

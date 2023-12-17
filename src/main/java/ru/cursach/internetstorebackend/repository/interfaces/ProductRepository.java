package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductForUpdateRowDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductShortDTO;

import java.util.List;

public interface ProductRepository {
    List<ProductShortDTO> getAllProductShortDTOBySubcategory(int idSubcategory, int limit, int offset);

    List<ProductDTO> getProductByCodeProduct(String codeProduct);

    int deleteProductByCodeProduct(String codeProduct);

    int updateProductByCodeProduct(String codeProduct, ProductForUpdateRowDTO product);
}

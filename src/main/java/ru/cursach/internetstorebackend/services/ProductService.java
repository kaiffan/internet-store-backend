package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductForUpdateRowDTO;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.repository.interfaces.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    public ProductDTO getProductByCodeProduct(String codeProduct) throws NotFoundException {
        List<ProductDTO> productDTO = productRepository.getProductByCodeProduct(codeProduct);
        if(productDTO.isEmpty()) {
            throw new NotFoundException("Список пуст!");
        }
        if(productDTO.size() > 1) {
            throw new IllegalArgumentException("Содержит больше 1 продукта!");
        }
        return productDTO.get(0);
    }

    public int deleteProductByCodeProduct(String codeProduct) {
        return productRepository.deleteProductByCodeProduct(codeProduct);
    }

    public int updateProductByCodeProduct(String codeProduct, ProductForUpdateRowDTO product) {
        return productRepository.updateProductByCodeProduct(codeProduct, product);
    }

}

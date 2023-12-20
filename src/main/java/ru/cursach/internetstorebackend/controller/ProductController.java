package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cursach.internetstorebackend.constants.ProductControllerConstant;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductForUpdateRowDTO;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.services.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping(RequestConstant.product)
public class ProductController {

    ProductService productService;

    @GetMapping(ProductControllerConstant.pathParamCodeProduct)
    public ProductDTO getProductByCodeProduct(
            @PathVariable String codeProduct
    ) throws NotFoundException {
        return productService.getProductByCodeProduct(codeProduct);
    }

    @DeleteMapping(ProductControllerConstant.pathParamCodeProduct)
    public int deleteProductByCodeProduct(
            @PathVariable String codeProduct
    ) {
        return productService.deleteProductByCodeProduct(codeProduct);
    }

    @PutMapping(ProductControllerConstant.pathParamCodeProduct)
    public int updateProductByCodeProduct(
            @PathVariable String codeProduct,
            @RequestBody ProductForUpdateRowDTO product) {
        return productService.updateProductByCodeProduct(codeProduct, product);
    }
}

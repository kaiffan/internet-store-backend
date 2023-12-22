package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.cursach.internetstorebackend.constants.ProductControllerConstant;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicOperationDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductUpdateRequest;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping(ProductControllerConstant.pathParamCodeProductEdit)
    public ProductCreateDTO getEditProductByCodeProduct(
            @PathVariable String codeProduct
    ) throws NotFoundException {
        return productService.getProductByCodeProductWithForeignKeys(codeProduct);
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
            @RequestBody ProductUpdateRequest product) {
        return productService.updateProductByCodeProduct(codeProduct, product);
    }

    @PatchMapping(ProductControllerConstant.pathParamCodeProductCharacteristics)
    public void patchCharacteristics(
            @RequestBody List<CharacteristicOperationDTO> characteristicDTOS,
            @PathVariable String codeProduct
    ) {
        productService.insertCharacteristics(codeProduct, characteristicDTOS);
    }
}

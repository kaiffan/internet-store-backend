package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.cursach.internetstorebackend.constants.CatalogueControllerConstant;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.CatalogueDTO;
import ru.cursach.internetstorebackend.domain.dto.SubcategoryWithProductsDTO;
import ru.cursach.internetstorebackend.domain.dto.request.ProductCreateDTO;
import ru.cursach.internetstorebackend.domain.entity.Product;
import ru.cursach.internetstorebackend.exceptions.NotFoundException;
import ru.cursach.internetstorebackend.services.CatalogueService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(RequestConstant.catalogue)
public class CatalogueController {
//    CategoryRepository categoryRepository;
//
//    @GetMapping
//    public List<Category> getAllCategories(){
//        return categoryRepository.getAllCategories();
//    }

    CatalogueService catalogueController;

    @GetMapping
    public List<CatalogueDTO> getCatalogue() {
        return catalogueController.getCatalogue();
    }

    @GetMapping(CatalogueControllerConstant.pathParamIdSubcategory)
    public SubcategoryWithProductsDTO getProductsInSubcategory(
            @PathVariable String idSubcategory,
            @RequestParam(name = "limit", required = false) int limit,
            @RequestParam(name = "offset", required = false) int offset
    ) {
        try {
            return catalogueController.getSubcategoryWithProductsDTO(Integer.parseInt(idSubcategory), limit, offset);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(CatalogueControllerConstant.pathParamIdSubcategory)
    public UUID insertProductBySubcategory(
            @PathVariable int idSubcategory,
            @RequestBody ProductCreateDTO productCreateDTO
    ) {
        return catalogueController.insertProductBySubcategory(idSubcategory, productCreateDTO);
    }
}

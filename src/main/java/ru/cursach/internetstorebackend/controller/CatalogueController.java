package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/api/catalog/")
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

    @GetMapping("/{idSubcategory}/")
    public SubcategoryWithProductsDTO getProductsInSubcategory(
            @PathVariable String idSubcategory,
            @RequestParam(name = "limit") int limit,
            @RequestParam(name = "offset") int offset
    ) {
        try {
            return catalogueController.getSubcategoryWithProductsDTO(Integer.parseInt(idSubcategory), limit, offset);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{idSubcategory}")
    public UUID insertProductBySubcategory(
            @PathVariable int idSubcategory,
            @RequestBody ProductCreateDTO productCreateDTO
    ) {
        return catalogueController.insertProductBySubcategory(idSubcategory, productCreateDTO);
    }
}

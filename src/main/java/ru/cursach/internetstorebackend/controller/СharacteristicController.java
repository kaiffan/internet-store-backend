package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.services.CharacteristicService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dimensions")
public class СharacteristicController {

    CharacteristicService characteristicService;

    @GetMapping("/{idSubcategory}")
    public List<TypeFeature> getAllTypeFeatureBySubcategory(
            @PathVariable int idSubcategory
    ) {
        return characteristicService.getAllTypeFeatureBySubcategory(idSubcategory);
    }
}

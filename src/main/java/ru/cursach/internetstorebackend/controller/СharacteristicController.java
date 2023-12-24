package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueDTO;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.services.CharacteristicService;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(RequestConstant.characteristic)
public class СharacteristicController {

    CharacteristicService characteristicService;

    @GetMapping("/{idSubcategory}")
    public List<TypeFeature> getAllTypeFeatureBySubcategory(
            @PathVariable int idSubcategory
    ) {
        return characteristicService.getAllTypeFeatureBySubcategory(idSubcategory);
    }

    @GetMapping("/typeFeature")
    public List<ReferenceValueDTO> getAllReferenceValueForTypeFeature(
            @RequestParam int[] ids
    ) {
        return characteristicService.getAllReferenceValueByTypeFeature(ids);
    }
}
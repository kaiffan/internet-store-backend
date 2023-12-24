package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueDTO;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CharacteristicService {
    CharacteristicRepository characteristicRepository;

    public List<TypeFeature> getAllTypeFeatureBySubcategory(int idSubcategory) {
        return characteristicRepository.getAllTypeFeatureBySubcategory(idSubcategory);
    }

    public List<ReferenceValueDTO> getAllReferenceValueByTypeFeature(int[] typeFeaturesIdList) {
        List<ReferenceValueDTO> referenceValues = new ArrayList<>();

        for (Integer typeFeatures : typeFeaturesIdList) {
            var referenceValue =
                    characteristicRepository.getAllReferenceValueByTypeFeature(typeFeatures);
            ReferenceValueDTO referenceValueDTO = characteristicRepository.getNameTypeFeature(typeFeatures);
            referenceValueDTO.setReferenceValues(referenceValue);
            referenceValues.add(referenceValueDTO);
        }
        return referenceValues;
    }
}

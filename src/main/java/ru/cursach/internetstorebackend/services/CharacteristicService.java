package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;
import ru.cursach.internetstorebackend.repository.interfaces.CharacteristicRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacteristicService {
    CharacteristicRepository characteristicRepository;

    public List<TypeFeature> getAllTypeFeatureBySubcategory(int idSubcategory) {
        return characteristicRepository.getAllTypeFeatureBySubcategory(idSubcategory);
    }
}

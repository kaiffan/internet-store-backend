package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;

import java.util.List;
import java.util.UUID;

public interface CharacteristicRepository {
    void insertCharacteristicByProduct(CharacteristicDTO characteristic, UUID codeProduct);

    List<TypeFeature> getAllTypeFeatureBySubcategory(int idSubcategory);
}

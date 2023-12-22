package ru.cursach.internetstorebackend.repository.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicOperationDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicProductDTO;
import ru.cursach.internetstorebackend.domain.dto.referenceValue.ReferenceValueForArrayDTO;
import ru.cursach.internetstorebackend.domain.entity.TypeFeature;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CharacteristicRepository {
    void insertCharacteristicByProduct(CharacteristicDTO characteristic, UUID codeProduct);

    List<TypeFeature> getAllTypeFeatureBySubcategory(int idSubcategory);

    List<CharacteristicProductDTO> getAllTypeFeatureByProductCode(String codeProduct);

    List<CharacteristicDTO> getAllTypeFeatureWithIDByProductCode(
            String codeProduct
    );

    List<ReferenceValueForArrayDTO> getAllReferenceValueByTypeFeature(int typeFeature);

    ReferenceValueDTO getNameTypeFeature(int typeFeature);

    void executeOperationCharacteristics(String codeProduct, List<CharacteristicOperationDTO> characteristicDTOS);
}

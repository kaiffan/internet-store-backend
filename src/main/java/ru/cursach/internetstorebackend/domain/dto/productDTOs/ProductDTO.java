package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicProductDTO;
import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDTO extends ExtendProductDTO {
    private String country;
    private String manufacturer;
    private List<CharacteristicProductDTO> characteristics;
}

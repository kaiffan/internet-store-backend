package ru.cursach.internetstorebackend.domain.dto.request;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;

import java.util.List;

@Data
public class ProductCreateDTO extends ProductUpdateRequest {
    private List<CharacteristicDTO> characteristics;
}

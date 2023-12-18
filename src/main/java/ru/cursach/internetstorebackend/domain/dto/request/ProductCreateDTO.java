package ru.cursach.internetstorebackend.domain.dto.request;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicDTO;
import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductDTOBase;

import java.util.List;

@Data
public class ProductCreateDTO extends ProductDTOBase {
    private int manufacturer;
    private int idCountry;
    private DimensionsDTO dimensions;
    private List<CharacteristicDTO> characteristics;
}

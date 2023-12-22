package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;

@Data
public class ExtendProductDTO extends ProductShortDTO {
    private String code_manufacturer;
    private String model;
    private Integer warranty;
    private DimensionsDTO dimensions;
}

package ru.cursach.internetstorebackend.domain.dto.request;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ExtendProductDTO;

@Data
public class ProductUpdateRequest extends ExtendProductDTO {
    private int idCountry;
    private int idManufacturer;
}

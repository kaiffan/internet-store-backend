package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.characteristic.CharacteristicProductDTO;
import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDTO extends ProductDTOBase{
    private UUID code_product;
    private String name;
    private String description;
    private String model;
    private String image;
    private String code_manufacturer;
    private Integer warranty;
    private Double raiting;
    private String country;
    private String manufacturer;
    private DimensionsDTO dimensions;
    private List<CharacteristicProductDTO> characteristics;
}

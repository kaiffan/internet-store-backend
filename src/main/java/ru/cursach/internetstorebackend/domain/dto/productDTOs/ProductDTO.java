package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.Data;
import ru.cursach.internetstorebackend.domain.entity.Dimensions;

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
    private Dimensions dimensions;
}

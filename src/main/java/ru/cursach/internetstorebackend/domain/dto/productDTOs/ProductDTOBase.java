package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTOBase {
    private UUID code_product;
    private String name;
    private String description;
    private String model;
    private String image;
    private String code_manufacturer;
    private Integer warranty;
    private Double raiting;
}

package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID code_product;
    private String name;
    private String description;
    private String image;
    private String code_manufacturer;
    private Integer warranty;
    private Double raiting;
    private Country id_country;
    private Subcategory id_subcategory;
    private Manufacturer id_manufacturer;
    private Dimensions id_dimensions;
}

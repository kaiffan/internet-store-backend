package ru.cursach.internetstorebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private String code_manufacturer;
    private Integer warranty;
    private Double raiting;
    private List<Country> id_country;
    private List<Subcategory> id_subcategory;
    private List<Manufacturer> id_manufacturer;
    private List<Dimensions> id_dimensions;
}

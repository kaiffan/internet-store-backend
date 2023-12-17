package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleflatmapper.map.annotation.Column;
import org.simpleflatmapper.map.annotation.Key;
import ru.cursach.internetstorebackend.annotation.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends Entity {
    @Key
    private UUID code_product;
    private String name;
    private String description;
    private String image;
    private String code_manufacturer;
    private Integer warranty;
    private Double raiting;
    private Country country;
    private Subcategory subcategory;
    private Manufacturer manufacturer;
    private Dimensions dimensions;
    private Boolean deleted;
}

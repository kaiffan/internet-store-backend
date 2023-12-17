package ru.cursach.internetstorebackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.domain.entity.Price;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductShortDTO {
    private UUID code_product;
    private String name;
    private String description;
    private String image;
    private double raiting;
    private Double price;
}

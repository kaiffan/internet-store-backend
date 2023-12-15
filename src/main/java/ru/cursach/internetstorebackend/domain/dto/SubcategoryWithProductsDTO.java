package ru.cursach.internetstorebackend.domain.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SubcategoryWithProductsDTO {
    private int id;
    private String title;
    private List<ProductShortDTO> products;
}

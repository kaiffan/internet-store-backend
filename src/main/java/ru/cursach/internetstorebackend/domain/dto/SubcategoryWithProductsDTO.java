package ru.cursach.internetstorebackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.domain.dto.productDTOs.ProductShortDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class SubcategoryWithProductsDTO {
    private int id;
    private String title;
    private List<ProductShortDTO> products;
}

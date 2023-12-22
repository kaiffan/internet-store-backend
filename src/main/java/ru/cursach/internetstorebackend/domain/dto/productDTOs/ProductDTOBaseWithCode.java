package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTOBaseWithCode extends ProductDTOBase {
    private UUID code_product;
}

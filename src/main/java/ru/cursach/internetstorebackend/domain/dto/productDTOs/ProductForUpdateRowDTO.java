package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.Data;

import java.util.UUID;


@Data
public class ProductForUpdateRowDTO extends ProductDTOBase {
    private int country;
    private int subcategory;
    private int manufacturer;
    private UUID dimensions;
}

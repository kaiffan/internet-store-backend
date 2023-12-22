package ru.cursach.internetstorebackend.domain.dto.productDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.domain.entity.Price;

import java.util.UUID;

@Data
public class ProductShortDTO extends ProductDTOBaseWithCode {
    private Double price;
}

package ru.cursach.internetstorebackend.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatalogueDTO {
    private int id;
    private String title;
    private List<CatalogueDTO> subcategories;
}

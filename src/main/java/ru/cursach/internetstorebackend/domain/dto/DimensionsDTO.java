package ru.cursach.internetstorebackend.domain.dto;

import lombok.Data;

@Data
public class DimensionsDTO {
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
}

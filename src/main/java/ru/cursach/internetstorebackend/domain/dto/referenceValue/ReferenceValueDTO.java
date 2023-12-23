package ru.cursach.internetstorebackend.domain.dto.referenceValue;

import lombok.Data;

import java.util.List;

@Data
public class ReferenceValueDTO {
    private int id;
    private String name;
    private List<ReferenceValueForArrayDTO> referenceValues;
}

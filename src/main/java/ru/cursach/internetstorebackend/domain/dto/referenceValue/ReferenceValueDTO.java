package ru.cursach.internetstorebackend.domain.dto.referenceValue;

import lombok.Data;

import java.util.List;

@Data
public class ReferenceValueDTO {
    private int idTypeFeature;
    private String nameTypeFeature;
    private List<String> referenceValues;
}

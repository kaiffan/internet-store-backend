package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.annotation.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table(name="characteristic")
public class Characteristic extends Entity{
    private String value;
    private int typeFeature;
    private UUID codeProduct;
}

package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.annotation.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table(name="reference_value")
public class ReferenceValue extends Entity {
    private UUID id;
    private String nameValue;
    private int typeFeature;
}

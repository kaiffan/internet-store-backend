package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cursach.internetstorebackend.annotation.Table;

@Data
@AllArgsConstructor
@Table(name="type_feature")
public class TypeFeature extends Entity{
    private int id;
    private String name;
    private int unitMeasurement;
    private String dataType;
}

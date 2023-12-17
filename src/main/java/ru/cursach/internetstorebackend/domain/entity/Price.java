package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.simpleflatmapper.map.annotation.Key;
import ru.cursach.internetstorebackend.annotation.Table;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Table(name="price")
public class Price extends Entity {
    @Key
    private UUID id;
    private Date start_action;
    private double value;
    private UUID id_product;
}

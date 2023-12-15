package ru.cursach.internetstorebackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Price extends Entity {
    private UUID id;
    private Date start_action;
    private double value;
    private UUID id_product;
}

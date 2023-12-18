package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.dto.DimensionsDTO;

import java.util.UUID;

public interface DimensionsRepository {
    UUID insertDimensionForProduct(DimensionsDTO dimensions);
}

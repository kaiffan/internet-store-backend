package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.entity.Manufacturer;

import java.util.List;

public interface ManufacturerRepository {
    List<Manufacturer> getAllManufacturer();
}

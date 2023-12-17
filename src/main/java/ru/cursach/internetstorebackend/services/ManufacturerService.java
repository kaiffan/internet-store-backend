package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.entity.Manufacturer;
import ru.cursach.internetstorebackend.repository.interfaces.ManufacturerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerService {
    ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.getAllManufacturer();
    }
}

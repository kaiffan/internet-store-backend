package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cursach.internetstorebackend.domain.entity.Manufacturer;
import ru.cursach.internetstorebackend.services.ManufacturerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/manufacturer")
public class ManufacturerController {

    ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerService.getAllManufacturer();
    }
}

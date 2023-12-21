package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cursach.internetstorebackend.constants.RequestConstant;
import ru.cursach.internetstorebackend.domain.entity.Manufacturer;
import ru.cursach.internetstorebackend.services.ManufacturerService;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(RequestConstant.manufacturer)
public class ManufacturerController {

    ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerService.getAllManufacturer();
    }
}

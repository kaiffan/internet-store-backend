package ru.cursach.internetstorebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cursach.internetstorebackend.domain.entity.Country;
import ru.cursach.internetstorebackend.repository.interfaces.CountryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }
}

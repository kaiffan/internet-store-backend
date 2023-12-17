package ru.cursach.internetstorebackend.repository.interfaces;

import ru.cursach.internetstorebackend.domain.entity.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> getAllCountries();
}

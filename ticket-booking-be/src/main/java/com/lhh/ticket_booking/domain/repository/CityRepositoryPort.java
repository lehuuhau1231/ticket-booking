package com.lhh.ticket_booking.domain.repository;

import com.lhh.ticket_booking.domain.model.City;

import java.util.List;
import java.util.Optional;

public interface CityRepositoryPort {
    City save(City city);
    Optional<City> findById(Long id);
    Optional<City> findByCode(String code);
    List<City> findAll();
}

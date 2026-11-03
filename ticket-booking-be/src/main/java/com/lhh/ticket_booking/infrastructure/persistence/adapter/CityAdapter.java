package com.lhh.ticket_booking.infrastructure.persistence.adapter;

import com.lhh.ticket_booking.domain.model.City;
import com.lhh.ticket_booking.domain.repository.CityRepositoryPort;
import com.lhh.ticket_booking.infrastructure.persistence.entity.CityJpaEntity;
import com.lhh.ticket_booking.infrastructure.persistence.mapper.CityPersistenceMapper;
import com.lhh.ticket_booking.infrastructure.persistence.repository.SpringDataCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CityAdapter implements CityRepositoryPort {
    private final SpringDataCityRepository springDataCityRepository;
    private final CityPersistenceMapper cityPersistenceMapper;

    @Override
    public City save(City city) {
        CityJpaEntity entity = cityPersistenceMapper.toEntity(city);
        CityJpaEntity saved = springDataCityRepository.save(entity);
        return cityPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<City> findById(Long id) {
        return springDataCityRepository.findById(id).map(cityPersistenceMapper::toDomain);
    }

    @Override
    public Optional<City> findByCode(String code) {
        return springDataCityRepository.findByCode(code).map(cityPersistenceMapper::toDomain);
    }

    @Override
    public List<City> findAll() {
        return springDataCityRepository.findAllByOrderByNameAsc().stream()
                .map(cityPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }
}

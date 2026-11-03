package com.lhh.ticket_booking.infrastructure.persistence.mapper;

import com.lhh.ticket_booking.domain.model.City;
import com.lhh.ticket_booking.infrastructure.persistence.entity.CityJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CityPersistenceMapper {

    public City toDomain(CityJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        return City.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public CityJpaEntity toEntity(City domain) {
        if (domain == null) {
            return null;
        }
        CityJpaEntity entity = CityJpaEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .code(domain.getCode())
                .build();
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());
        return entity;
    }
}

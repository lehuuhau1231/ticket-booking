package com.lhh.ticket_booking.infrastructure.persistence.repository;

import com.lhh.ticket_booking.infrastructure.persistence.entity.CityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataCityRepository extends JpaRepository<CityJpaEntity, Long> {
    Optional<CityJpaEntity> findByCode(String code);
    List<CityJpaEntity> findAllByOrderByNameAsc();
}

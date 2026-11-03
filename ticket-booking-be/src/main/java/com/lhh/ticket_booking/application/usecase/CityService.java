package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.CityResult;
import com.lhh.ticket_booking.application.port.in.GetCitiesUseCase;
import com.lhh.ticket_booking.domain.repository.CityRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService implements GetCitiesUseCase {

    private final CityRepositoryPort cityRepositoryPort;

    @Override
    public List<CityResult> getCities() {
        return cityRepositoryPort.findAll().stream()
                .map(city -> CityResult.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .code(city.getCode())
                        .build())
                .collect(Collectors.toList());
    }
}

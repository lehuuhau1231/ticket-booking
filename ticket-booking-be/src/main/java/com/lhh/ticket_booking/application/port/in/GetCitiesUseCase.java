package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.CityResult;

import java.util.List;

public interface GetCitiesUseCase {
    List<CityResult> getCities();
}

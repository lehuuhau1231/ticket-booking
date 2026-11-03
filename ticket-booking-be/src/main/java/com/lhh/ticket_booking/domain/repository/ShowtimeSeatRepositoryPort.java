package com.lhh.ticket_booking.domain.repository;

import com.lhh.ticket_booking.application.dto.SeatTypePriceResult;

import java.util.List;

public interface ShowtimeSeatRepositoryPort {
    List<SeatTypePriceResult> getSeatTypeByShowtimeId(List<Long> showtimeId);
}

package com.lhh.ticket_booking.infrastructure.persistence.adapter;

import com.lhh.ticket_booking.application.dto.SeatTypePriceResult;
import com.lhh.ticket_booking.domain.repository.ShowtimeSeatRepositoryPort;
import com.lhh.ticket_booking.infrastructure.persistence.repository.SpringDataShowtimeSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowtimeSeatAdapter implements ShowtimeSeatRepositoryPort {
    private final SpringDataShowtimeSeatRepository showtimeSeatRepository;

    @Override
    public List<SeatTypePriceResult> getSeatTypeByShowtimeId(List<Long> showtimeId) {
        return showtimeSeatRepository.getSeatTypeByShowtimeId(showtimeId);
    }
}

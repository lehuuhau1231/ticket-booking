package com.lhh.ticket_booking.infrastructure.persistence.adapter;

import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;
import com.lhh.ticket_booking.domain.repository.ShowtimeRepositoryPort;
import com.lhh.ticket_booking.infrastructure.persistence.repository.SpringDataShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowtimeAdapter implements ShowtimeRepositoryPort {
    private final SpringDataShowtimeRepository showtimeRepository;

    @Override
    public List<ShowtimeSummaryResult> findShowtimeByEventId(Long id) {
        return showtimeRepository.findShowtimeByEventId(id);
    }
}

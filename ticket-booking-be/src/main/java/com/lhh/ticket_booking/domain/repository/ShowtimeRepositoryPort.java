package com.lhh.ticket_booking.domain.repository;

import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;

import java.util.List;

public interface ShowtimeRepositoryPort {
    List<ShowtimeSummaryResult> findShowtimeByEventId(Long id);

}

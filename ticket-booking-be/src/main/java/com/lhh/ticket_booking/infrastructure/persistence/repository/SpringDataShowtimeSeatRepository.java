package com.lhh.ticket_booking.infrastructure.persistence.repository;

import com.lhh.ticket_booking.application.dto.SeatTypePriceResult;
import com.lhh.ticket_booking.infrastructure.persistence.entity.ShowtimeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataShowtimeSeatRepository extends JpaRepository<ShowtimeJpaEntity, Long> {
    @Query("""
        SELECT new com.lhh.ticket_booking.application.dto.SeatTypePriceResult(ss.showtime.id, ss.price, s.seatType)
        FROM ShowtimeSeatJpaEntity ss
        JOIN ss.seat s
        WHERE ss.showtime.id IN :showtimeId
        GROUP BY ss.showtime.id, ss.price, s.seatType
    """)
    List<SeatTypePriceResult> getSeatTypeByShowtimeId(@Param("showtimeId") List<Long> showtimeId);
}

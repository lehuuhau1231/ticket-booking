package com.lhh.ticket_booking.infrastructure.persistence.repository;

import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;
import com.lhh.ticket_booking.infrastructure.persistence.entity.ShowtimeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SpringDataShowtimeRepository extends JpaRepository<ShowtimeJpaEntity, Long> {

    @Query("SELECT s.event.id, MIN(s.basePrice) FROM ShowtimeJpaEntity s WHERE s.event.id IN :eventIds GROUP BY s.event.id")
    List<Object[]> findMinPricesByEventIds(@Param("eventIds") Collection<Long> eventIds);

    @Query("""
        SELECT new com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult(st.id, st.startTime, st.endTime,
        st.basePrice, st.status, a.name)
        FROM ShowtimeJpaEntity st
        JOIN st.auditorium a
        WHERE st.event.id = :eventId
    """)
    List<ShowtimeSummaryResult> findShowtimeByEventId(@Param("eventId") Long eventId);
}

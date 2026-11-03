package com.lhh.ticket_booking.infrastructure.persistence.repository;

import com.lhh.ticket_booking.application.dto.EventDetailResult;
import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.infrastructure.dto.EventSummaryJpaDto;
import com.lhh.ticket_booking.infrastructure.persistence.entity.EventJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lhh.ticket_booking.domain.enums.EventStatus;

import java.util.List;

@Repository
public interface SpringDataEventRepository extends JpaRepository<EventJpaEntity, Long> {

    @Query("""
            SELECT new com.lhh.ticket_booking.application.dto.EventSummaryResult(
                    e.id, e.title, e.posterUrl, e.category, e.status, c.name, e.startDate
                    )
            FROM EventJpaEntity e
            LEFT JOIN e.city c
            WHERE (e.status IN (EventStatus.UPCOMING, EventStatus.ACTIVE))
              AND (:keyword IS NULL OR :keyword = '' OR LOWER(e.title) LIKE LOWER(CONCAT('%', :keyword, '%')))
              AND (:cityCode IS NULL OR :cityCode = '' OR c.code = :cityCode)
              AND (:category IS NULL OR e.category = :category)
            ORDER BY e.startDate ASC, e.id DESC
        """
    )
    Page<EventSummaryResult> searchEvents(
            @Param("keyword") String keyword,
            @Param("cityCode") String cityCode,
            @Param("category") EventCategory category,
            Pageable pageable
    );

    @Query("""
        SELECT new com.lhh.ticket_booking.application.dto.EventDetailResult(
            e.id, e.title, e.description, e.durationMinutes, e.posterUrl, e.category, c.name, e.locationName,
            e.status
        ) FROM EventJpaEntity e
        JOIN e.city c
        WHERE e.id = :id
    """)
    EventDetailResult findByEventId(@Param("id") Long id);
}

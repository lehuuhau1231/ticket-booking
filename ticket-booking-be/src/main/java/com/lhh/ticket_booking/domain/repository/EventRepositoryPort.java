package com.lhh.ticket_booking.domain.repository;

import com.lhh.ticket_booking.application.dto.EventDetailResult;
import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;
import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventRepositoryPort {
    Event save(Event event);
    EventDetailResult findByEventId(Long id);
    Page<EventSummaryResult> searchEvents(String keyword, String cityCode, EventCategory category, Pageable pageable);
}

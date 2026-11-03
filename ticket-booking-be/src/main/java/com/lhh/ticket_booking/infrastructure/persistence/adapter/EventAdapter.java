package com.lhh.ticket_booking.infrastructure.persistence.adapter;

import com.lhh.ticket_booking.application.dto.EventDetailResult;
import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.domain.enums.EventCategory;
import com.lhh.ticket_booking.domain.model.Event;
import com.lhh.ticket_booking.domain.repository.EventRepositoryPort;
import com.lhh.ticket_booking.infrastructure.persistence.repository.SpringDataEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventAdapter implements EventRepositoryPort {
    private final SpringDataEventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public EventDetailResult findByEventId(Long id) {
        return eventRepository.findByEventId(id);
    }

    @Override
    public Page<EventSummaryResult> searchEvents(String keyword, String cityCode, EventCategory category, Pageable pageable) {
        return eventRepository.searchEvents(keyword, cityCode, category, pageable);
    }
}

package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.EventDetailResult;

public interface GetEventDetailUseCase {
    EventDetailResult getEventById(Long id);
}

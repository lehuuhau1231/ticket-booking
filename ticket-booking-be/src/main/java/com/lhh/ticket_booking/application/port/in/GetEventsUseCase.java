package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.application.dto.PageResult;

public interface GetEventsUseCase {
    PageResult<EventSummaryResult> getEvents(String keyword, String city, String category, int page, int size);
}

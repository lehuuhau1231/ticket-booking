package com.lhh.ticket_booking.presentation.mapper;

import org.mapstruct.Mapper;

import com.lhh.ticket_booking.application.dto.EventSummaryResult;
import com.lhh.ticket_booking.application.dto.ShowtimeSummaryResult;
import com.lhh.ticket_booking.presentation.dto.response.EventSummaryResponse;
import com.lhh.ticket_booking.presentation.dto.response.ShowtimeResponse;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventSummaryResponse toEventSummaryResponse(EventSummaryResult result);

    ShowtimeResponse toShowtimeResponse(ShowtimeSummaryResult result);
}

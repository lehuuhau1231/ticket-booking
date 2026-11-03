package com.lhh.ticket_booking.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventSummaryResponse {
    private Long id;
    private String title;
    private String description;
    private String posterUrl;
    private String category;
    private CityResponse city;
    private String locationName;
    private LocalDateTime startDate;
    private BigDecimal minPrice;
    private List<String> artists;
}

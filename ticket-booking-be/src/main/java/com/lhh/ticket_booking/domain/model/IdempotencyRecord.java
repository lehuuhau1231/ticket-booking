package com.lhh.ticket_booking.domain.model;

import com.lhh.ticket_booking.domain.enums.IdempotencyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdempotencyRecord {
    private Long id;
    private String idempotencyKey;
    private String requestHash;
    @Builder.Default
    private IdempotencyStatus status = IdempotencyStatus.PROCESSING;
    private Integer responseCode;
    private String responseBody;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

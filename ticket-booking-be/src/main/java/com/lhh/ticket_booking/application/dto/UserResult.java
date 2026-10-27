package com.lhh.ticket_booking.application.dto;

import com.lhh.ticket_booking.domain.enums.UserRole;
import com.lhh.ticket_booking.domain.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResult {
    private Long id;
    private String email;
    private UserRole role;
    private UserStatus status;
}

package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.UserResult;

public interface GetCurrentUserUseCase {
    UserResult getCurrentUser();
}

package com.lhh.ticket_booking.application.port.in;

import com.lhh.ticket_booking.application.dto.RegisterUserCommand;

public interface RegisterUserUseCase {
    void register(RegisterUserCommand command);
}

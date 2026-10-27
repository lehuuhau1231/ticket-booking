package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.RegisterUserCommand;
import com.lhh.ticket_booking.application.port.in.RegisterUserUseCase;
import com.lhh.ticket_booking.application.port.out.IdGeneratorPort;
import com.lhh.ticket_booking.application.port.out.PasswordEncoderPort;
import com.lhh.ticket_booking.domain.enums.UserRole;
import com.lhh.ticket_booking.domain.enums.UserStatus;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final IdGeneratorPort idGeneratorPort;

    @Override
    @Transactional
    public void register(RegisterUserCommand command) {
        if (userRepositoryPort.existsByEmail(command.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = User.builder()
                .id(idGeneratorPort.generateId())
                .email(command.getEmail())
                .password(passwordEncoderPort.encode(command.getPassword()))
                .role(UserRole.CUSTOMER)
                .status(UserStatus.ACTIVE)
                .build();

        userRepositoryPort.save(user);
    }
}

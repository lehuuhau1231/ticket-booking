package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.LoginCommand;
import com.lhh.ticket_booking.application.dto.LoginResult;
import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.application.mapper.UserAppMapper;
import com.lhh.ticket_booking.application.port.in.LoginUseCase;
import com.lhh.ticket_booking.application.port.out.PasswordEncoderPort;
import com.lhh.ticket_booking.application.port.out.TokenProviderPort;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final TokenProviderPort tokenProviderPort;
    private final UserAppMapper userAppMapper;

    @Override
    public LoginResult login(LoginCommand command) {
        User user = userRepositoryPort.findByEmail(command.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoderPort.matches(command.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        String token = tokenProviderPort.generateToken(user);
        UserResult userResult = userAppMapper.toUserResult(user);

        return LoginResult.builder()
                .user(userResult)
                .token(token)
                .build();
    }
}

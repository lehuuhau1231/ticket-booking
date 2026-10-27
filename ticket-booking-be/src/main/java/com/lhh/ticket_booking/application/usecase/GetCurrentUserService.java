package com.lhh.ticket_booking.application.usecase;

import com.lhh.ticket_booking.application.dto.UserResult;
import com.lhh.ticket_booking.application.mapper.UserAppMapper;
import com.lhh.ticket_booking.application.port.in.GetCurrentUserUseCase;
import com.lhh.ticket_booking.application.port.out.CurrentUserPort;
import com.lhh.ticket_booking.domain.exception.AppException;
import com.lhh.ticket_booking.domain.exception.ErrorCode;
import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCurrentUserService implements GetCurrentUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final UserAppMapper userAppMapper;

    @Override
    public UserResult getCurrentUser() {
        String userId = currentUserPort.getCurrentUserId();
        User user = userRepositoryPort.findById(Long.parseLong(userId))
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return userAppMapper.toUserResult(user);
    }
}

package com.lhh.ticket_booking.infrastructure.persistence.adapter;

import com.lhh.ticket_booking.domain.model.User;
import com.lhh.ticket_booking.domain.repository.UserRepositoryPort;
import com.lhh.ticket_booking.infrastructure.persistence.entity.UserJpaEntity;
import com.lhh.ticket_booking.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.lhh.ticket_booking.infrastructure.persistence.repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final SpringDataUserRepository springDataUserRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User save(User user) {
        UserJpaEntity entity = userPersistenceMapper.toEntity(user);
        UserJpaEntity saved = springDataUserRepository.save(entity);
        return userPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return springDataUserRepository.findById(id).map(userPersistenceMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email).map(userPersistenceMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataUserRepository.existsByEmail(email);
    }
}

package com.lhh.ticket_booking.infrastructure.generator;

import cn.hutool.core.lang.Snowflake;
import com.lhh.ticket_booking.application.port.out.IdGeneratorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HutoolSnowflakeIdGeneratorAdapter implements IdGeneratorPort {
    private final Snowflake snowflake;

    @Override
    public long generateId() {
        return snowflake.nextId();
    }
}

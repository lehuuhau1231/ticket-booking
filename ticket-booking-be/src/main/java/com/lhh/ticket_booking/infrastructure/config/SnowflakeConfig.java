package com.lhh.ticket_booking.infrastructure.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig {
    @Bean
    public Snowflake getSnowflake() {
        return IdUtil.getSnowflake(1, 1);
    }
}

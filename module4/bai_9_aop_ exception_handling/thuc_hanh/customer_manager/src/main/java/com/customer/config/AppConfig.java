package com.customer.config;

import com.customer.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Logger logger() {
        return new Logger();
    }
}

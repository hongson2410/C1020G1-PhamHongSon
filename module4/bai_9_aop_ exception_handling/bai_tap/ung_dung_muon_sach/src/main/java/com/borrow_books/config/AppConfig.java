package com.borrow_books.config;

import com.borrow_books.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public Logger logger() {
        return new Logger();
    }

}

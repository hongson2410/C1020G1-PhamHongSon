package com.borrow_books.config;

import com.borrow_books.concern.Aop;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public Aop aop() {
        return new Aop();
    }

}

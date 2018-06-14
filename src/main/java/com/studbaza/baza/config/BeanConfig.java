package com.studbaza.baza.config;

import com.studbaza.baza.model.Event;
import com.studbaza.baza.model.EventDaoImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Bean config
 */
@Configuration
@ComponentScan(basePackages="com")
public class BeanConfig{

    @Bean
    public Event getEvent() {
        return new Event();
    }

}


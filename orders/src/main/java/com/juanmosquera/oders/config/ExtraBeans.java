package com.juanmosquera.oders.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtraBeans {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

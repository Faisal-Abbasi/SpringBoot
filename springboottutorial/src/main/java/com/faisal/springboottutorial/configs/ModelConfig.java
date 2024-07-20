package com.faisal.springboottutorial.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelConfig {
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}

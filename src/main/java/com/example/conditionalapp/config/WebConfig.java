package com.example.conditionalapp.config;

import com.example.conditionalapp.profiles.DevProfile;
import com.example.conditionalapp.profiles.ProductionProfile;
import com.example.conditionalapp.profiles.interfaces.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

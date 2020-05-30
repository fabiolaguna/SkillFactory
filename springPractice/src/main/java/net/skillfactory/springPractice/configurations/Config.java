package net.skillfactory.springPractice.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${user.countrycode}")
    private String countryCode;

    @Bean
    public String getCountryCode() {
        return countryCode;
    }
}

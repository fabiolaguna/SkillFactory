package net.skillfactory.springPractice.configurations;

import net.skillfactory.springPractice.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public User getNewUser() {
        return new User();
    }
}

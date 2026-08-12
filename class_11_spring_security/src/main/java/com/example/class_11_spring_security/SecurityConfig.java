package com.example.class_11_spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http){

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/sign-up", "/terms", "/sign-in").permitAll()
                        .requestMatchers("/admin/**").denyAll()
                        .requestMatchers("/password").fullyAuthenticated()
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/sign-in"))
        .logout(Customizer.withDefaults())
                .rememberMe(Customizer.withDefaults());
        return http.build();
    }
}

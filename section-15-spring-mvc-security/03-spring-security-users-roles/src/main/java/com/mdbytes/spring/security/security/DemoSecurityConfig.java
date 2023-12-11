package com.mdbytes.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john@company.com").roles("EMPLOYEE").password("{noop}test123").build();
        UserDetails mary = User.builder().username("mary@company.com").roles("EMPLOYEE", "MANAGER").password("{noop}test123").build();
        UserDetails susan = User.builder().username("susan@company.com").roles("EMPLOYEE", "MANAGER", "ADMIN").password("{noop}test123").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                                .anyRequest().authenticated()

                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/auth")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .permitAll()
                );

        return http.build();
    }
}

package com.mdbytes.spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").roles("EMPLOYEE").password("{noop}test123").build();
        UserDetails mary = User.builder().username("mary").roles("EMPLOYEE", "MANAGER").password("{noop}test123").build();
        UserDetails susan = User.builder().username("susan").roles("EMPLOYEE", "MANAGER", "ADMIN").password("{noop}test123").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}

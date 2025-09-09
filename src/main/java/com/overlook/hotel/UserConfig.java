package com.overlook.hotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
  @Bean
  public InMemoryUserDetailsManager users() {
    UserDetails admin = User.withUsername("admin")
        .password("{noop}admin123") // {noop} = no encoder for dev
        .roles("USER", "ADMIN")
        .build();
    return new InMemoryUserDetailsManager(admin);
  }
}

package com.eps.Appointments.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.eps.Appointments.Security.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private JpaUserDetailsService jpaUserDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.userDetailsService(jpaUserDetailsService)
				.build();
	}

}

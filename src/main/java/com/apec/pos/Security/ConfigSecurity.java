package com.apec.pos.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apec.pos.service.JwtService;



@Configuration
public class ConfigSecurity {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private JwtFilterSecurity jwtFilterSecurity;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth ->{
				auth.requestMatchers("/auth/**").permitAll();
				auth.requestMatchers("/admin/**").hasAuthority("ADMIN");
				auth.requestMatchers("/user/**").hasAuthority("USER");
				auth.anyRequest().authenticated();
			});
		 http.sessionManagement(
	                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            );
	       http.addFilterBefore(jwtFilterSecurity, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
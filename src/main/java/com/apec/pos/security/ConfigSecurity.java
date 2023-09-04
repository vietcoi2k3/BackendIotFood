package com.apec.pos.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors().and()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/swagger-ui/**",
                            "/v3/api-docs/**").permitAll();
                    auth.requestMatchers("/ws-iotfood/**").permitAll();
                    auth.requestMatchers("/auth/**").permitAll();
                    auth.requestMatchers("/ADMIN/*").hasAnyAuthority("ADMIN", "EMPLOYEE");
                    auth.requestMatchers("/ADMIN/MANAGER/**").hasAuthority("ADMIN");
                    auth.requestMatchers("/user/**").hasAuthority("USER");
                    auth.anyRequest().authenticated();
                });
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.addFilterBefore(jwtFilterSecurity, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("**");
        corsConfig.addAllowedOrigin("http://127.0.0.1:5500");
        corsConfig.addAllowedOrigin("https://iotfood.vercel.app");// Replace with your frontend origin
        corsConfig.addAllowedOrigin("http://localhost:5173");
        corsConfig.addAllowedOrigin("http://127.0.0.1:5173");
        corsConfig.addAllowedOrigin("https://thangdev.online");
        corsConfig.addAllowedOrigin("http://14.225.206.173:8080");
//		  	corsConfig.addAllowedOrigin("*");

        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
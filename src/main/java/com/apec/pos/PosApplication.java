package com.apec.pos;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
public class PosApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PosApplication.class, args);
    }

    public static String currentUserGlobal = "";

  
}

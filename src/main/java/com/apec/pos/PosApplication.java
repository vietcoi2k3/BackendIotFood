package com.apec.pos;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class PosApplication extends SpringBootServletInitializer {

    public static void main(String[] args)throws IOException {
        SpringApplication.run(PosApplication.class, args);

    }

    public static String currentUserGlobal = "";
//    public static String currentUrlGlobal = "";

  
}

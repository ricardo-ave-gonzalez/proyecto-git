package com.deverlop.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author richie
 */
@Configuration
//@EnableWebMvc
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("http://localhost:8080")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("header1", "header2", "header3")
                        .exposedHeaders("header1", "header2")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }
}

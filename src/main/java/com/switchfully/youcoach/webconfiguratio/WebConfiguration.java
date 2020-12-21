package com.switchfully.youcoach.webconfiguratio;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/users")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("POST")
                .allowedMethods("GET")
                .allowedMethods("PUT")
                .allowedMethods("OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/users/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("POST")
                .allowedMethods("GET")
                .allowedMethods("PUT")
                .allowedMethods("OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/users")
                .allowedOrigins("https://5fe0b4d723860544097907bb--suspicious-euler-0c1f69.netlify.app")
                .allowedMethods("POST")
                .allowedMethods("GET")
                .allowedMethods("PUT")
                .allowedMethods("OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/users/**")
                .allowedOrigins("https://5fe0b4d723860544097907bb--suspicious-euler-0c1f69.netlify.app")
                .allowedMethods("POST")
                .allowedMethods("GET")
                .allowedMethods("PUT")
                .allowedMethods("OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

package com.example.HospitalManagementSystem.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Configuration
    public class AppConfig1 {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

}

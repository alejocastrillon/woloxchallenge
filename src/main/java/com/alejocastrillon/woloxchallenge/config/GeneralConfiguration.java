/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * General configuration class project.
 *
 * @author alejandroutp
 */
@Configuration
public class GeneralConfiguration {

    /**
     * Configure rest template, for consume external rest service.
     *
     * @return Configured rest template instance
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

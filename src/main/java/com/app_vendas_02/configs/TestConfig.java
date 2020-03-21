package com.app_vendas_02.configs;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.app_vendas_02.services.DbService;
import com.app_vendas_02.services.EmailService;
import com.app_vendas_02.services.MockEmailService;

/**
 * TestConfig
 */
@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService _dbService;

    @Bean
    public boolean instancianteDataBase() throws ParseException {

        _dbService.instanciateTestDataBase();
        return true;
    }
    
    @Bean
    public EmailService emailService() {
    	return new MockEmailService();
    }
}
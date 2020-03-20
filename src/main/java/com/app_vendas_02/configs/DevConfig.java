package com.app_vendas_02.configs;

import java.text.ParseException;

import com.app_vendas_02.services.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * DevConfig
 */
@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DbService _dbServive;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciateDataBase() throws ParseException {

        if (!"create".equals(strategy)) {
            return false;
        }
        _dbServive.instanciateTestDataBase();
        return true;
    }

}
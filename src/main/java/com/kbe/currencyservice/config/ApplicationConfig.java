package com.kbe.currencyservice.config;

import com.kbe.currencyservice.domain.CurrencyCalculationUtils;
import com.kbe.currencyservice.domain.CurrencyCalculationUtilsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CurrencyCalculationUtils getCurrencyCalculationUtils(){return new CurrencyCalculationUtilsImpl();}
}

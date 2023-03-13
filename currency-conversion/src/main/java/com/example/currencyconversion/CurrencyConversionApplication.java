package com.example.currencyconversion;

import com.example.currencyconversion.controllers.CurrencyExchangeProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = CurrencyExchangeProxy.class)
public class CurrencyConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class, args);
    }

}

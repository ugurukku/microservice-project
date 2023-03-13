package com.ugurukku.currencyexchange.controller;

import com.ugurukku.currencyexchange.entity.CurrencyExchange;
import com.ugurukku.currencyexchange.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyExchangeRepository repository;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to) {

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;

    }


}

package com.ugurukku.currencyexchange.repository;

import com.ugurukku.currencyexchange.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from, String to);

}

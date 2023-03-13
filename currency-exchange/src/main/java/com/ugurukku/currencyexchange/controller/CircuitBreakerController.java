package com.ugurukku.currencyexchange.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    // INFO : Rate limiter limits number of requests in specific period
    // INFO : Retry and CircuitBreaker tries method if something went wrong
    // INFO : Bulkhead controls number of concurrent calls
    @GetMapping("/sample-api")
//    @Retry(name = "sample",fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default",fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "sample-api")
    public String sampleApi() {
        logger.info("Api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//        return forEntity.getBody();
        return "sample";
    }

    public String hardcodedResponse(Exception exception){
        return "fallback response";
    }

}

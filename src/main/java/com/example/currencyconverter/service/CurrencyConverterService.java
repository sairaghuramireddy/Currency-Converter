package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

    private final RestTemplate restTemplate;
    
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public CurrencyConverterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double convertUsdToInr(Double amountInUsd) {
        ExchangeRateResponse response = restTemplate.getForObject(API_URL, ExchangeRateResponse.class);
        if (response != null && response.getRates().containsKey("YEN")) {
            Double exchangeRate = response.getRates().get("YEN");
            return amountInUsd * exchangeRate;
        }
        throw new RuntimeException("Unable to fetch exchange rate.");
    }
}

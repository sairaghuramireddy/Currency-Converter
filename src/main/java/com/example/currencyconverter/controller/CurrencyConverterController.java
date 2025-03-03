package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;

    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    @GetMapping("/convertCurrency")
    public Double convertCurrency(@RequestParam Double amount) {
        return currencyConverterService.convertUsdToInr(amount);
    }
}

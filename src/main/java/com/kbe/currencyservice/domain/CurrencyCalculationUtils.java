package com.kbe.currencyservice.domain;

import com.kbe.currencyservice.entity.Currency;

public interface CurrencyCalculationUtils {

    double convertEuroInGivenCurrency(double price, Currency currency);
}

package com.kbe.currencyservice.domain;

import com.kbe.currencyservice.entity.Currency;

public class CurrencyCalculationUtilsImpl implements CurrencyCalculationUtils{
    private final double MXNCONVERTVALUE = 22;
    private final double USDCONVERTVALUE = 1.1;
    private final double CADCONVERTVALUE = 21.4;
    private final double YENCONVERTVALUE = 135;
    private final double PNDCONVERTVALUE = 0.9;

    @Override
    public  double convertEuroInGivenCurrency(double price, Currency currency){
        switch (currency) {
            case MXN:
                return price * MXNCONVERTVALUE;
            case USD:
                return price * USDCONVERTVALUE;
            case CAD:
                return price * CADCONVERTVALUE;
            case YEN:
                return price * YENCONVERTVALUE;
            case PND:
                return price * PNDCONVERTVALUE;
            default:
                return price;
        }
    }
}

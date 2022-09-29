package com.kbe.currencyservice.domain;

import com.kbe.currencyservice.config.RabbitConfig;
import com.kbe.currencyservice.entity.CurrencyRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyServiceController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private CurrencyCalculationUtils currencyCalculationUtils;

    @RabbitListener(queues = RabbitConfig.QUEUEFORREQUESTS)
    private double receiveRequest(CurrencyRequest requestCall){
        return currencyCalculationUtils.convertEuroInGivenCurrency(requestCall.getPrice(), requestCall.getCurrency());
    }
}

package com.kbe.currencyservice.domain;

import com.kbe.currencyservice.config.RabbitConfig;
import com.kbe.currencyservice.entity.Currency;
import com.kbe.currencyservice.entity.CurrencyRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyServiceController {

    @Autowired
    public RabbitTemplate template;

    @RabbitListener(queues = RabbitConfig.QUEUEFORREQUESTS)
    public double receiveRequest(CurrencyRequest requestCall){
        System.out.println("currency calculation request call with id: " + requestCall.getId() + " received with value of: " + requestCall.getPrice() + " and requested currency: " + requestCall.getCurrency());
        return calculatePriceInCurrency(requestCall.getPrice(), requestCall.getCurrency());
        //template.convertAndSend(RabbitConfig.EXCHANGEFORANSWERS, RabbitConfig.ANSWERROUTINGKEY, requestCall);
        //System.out.println("currency calculated for id: " + requestCall.getId() + ", with price: " + requestCall.getPrice() + " in " + requestCall.getCurrency());
    }

    public double calculatePriceInCurrency(double price, Currency currency){
        switch (currency) {
            case MXN:
                return price * 22;
            case USD:
                return price * 1.1;
            case CAD:
                return price * 1.4;
            case YEN:
                return price * 135;
            case PND:
                return price * 0.9;
            default:
                return price;
        }
    }
}

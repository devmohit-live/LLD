package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentHandler implements IPaymentHandler {
    private CreditCard creditCard;
    public CreditCardPaymentHandler(){
        this.creditCard = new CreditCard();
    }
    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("CreditCardPaymentHandler pay called");
        return this.creditCard.pay(cardNumber, cvv, expiryDate, amount);
    }
}

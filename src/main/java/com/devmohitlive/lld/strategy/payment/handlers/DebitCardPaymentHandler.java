package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.CreditCard;
import com.devmohitlive.lld.strategy.payment.vendors.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebitCardPaymentHandler implements IPaymentHandler {
    @Autowired
    DebitCard debitCard;

    public DebitCardPaymentHandler() {
        this.debitCard = new DebitCard();
    }

    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("DebitCardPaymentHandler pay called");
        return this.debitCard.pay(cardNumber, cvv, expiryDate, amount);
    }
}

package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentHandler implements IPaymentHandler {
    @Autowired
    private CreditCard creditCard;
    private final PaymentMethod paymentMethod = PaymentMethod.CREDIT_CARD;

    public CreditCardPaymentHandler(){
        this.creditCard = new CreditCard();
    }
    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("CreditCardPaymentHandler pay called");
        return this.creditCard.pay(cardNumber, cvv, expiryDate, amount);
    }



    @Override
    public boolean isValidPaymentMethod(PaymentMethod paymentMethod) {
        return getPaymentMethod() == paymentMethod;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
}

package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.*;
import com.devmohitlive.lld.strategy.payment.vendors.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentHandler implements CardPaymentHandler {
    @Autowired
    private CreditCard creditCard;
    private final PaymentMethod paymentMethod = PaymentMethod.CREDIT_CARD;
    private final Quota quota = Quota.NORMAL;

    @Override
    public PaymentStatus pay(IPaymentRequest paymentRequest, double amount) {
        CreditCardPaymentRequest creditCardPaymentRequest = (CreditCardPaymentRequest) paymentRequest;
        return this.pay(creditCardPaymentRequest, amount);
    }

    private PaymentStatus pay(CreditCardPaymentRequest paymentRequest, double amount){
        System.out.println("CreditCardPaymentHandler pay called");
        return this.creditCard.pay(paymentRequest.getCardNumber(), paymentRequest.getCvv(), paymentRequest.getExpiryDate(), amount);
    }


    @Override
    public boolean isValidPaymentMethod(User user, PaymentMethod paymentMethod) {
        return getPaymentMethod() == paymentMethod && user.getQuota() == this.quota;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
}

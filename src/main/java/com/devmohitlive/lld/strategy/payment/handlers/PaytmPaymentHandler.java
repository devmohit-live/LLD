package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.*;
import com.devmohitlive.lld.strategy.payment.vendors.Paytm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaytmPaymentHandler implements IPaymentHandler{
    @Autowired
    private Paytm paytm;
    private final PaymentMethod paymentMethod = PaymentMethod.PAYTM;

    private PaymentStatus pay(PaytmPaymentRequest paymentRequest, double amount) {
        System.out.println("PaytmPaymentHandler pay called");
        return this.paytm.pay(paymentRequest.getPaytmMobileNumber(), amount);
    }

    @Override
    public PaymentStatus pay(IPaymentRequest paymentRequest, double amount) {
        return this.pay((PaytmPaymentRequest) paymentRequest, amount);
    }

    @Override
    public boolean isValidPaymentMethod(User user, PaymentMethod paymentMethod) {
        return getPaymentMethod() == paymentMethod;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
}

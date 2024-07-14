package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.*;
import com.devmohitlive.lld.strategy.payment.vendors.UPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UPIPaymentHandler implements IPaymentHandler{
    @Autowired
    private UPI upi;
    private final PaymentMethod paymentMethod = PaymentMethod.UPI;


    private PaymentStatus pay(UPIPaymentRequest upiPaymentRequest, double amount) {
        System.out.println("UPIPaymentHandler pay called");
        return this.upi.pay(upiPaymentRequest.getUpiId(), amount);
    }

    @Override
    public PaymentStatus pay(IPaymentRequest paymentRequest, double amount) {
        return this.pay((UPIPaymentRequest) paymentRequest, amount);
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

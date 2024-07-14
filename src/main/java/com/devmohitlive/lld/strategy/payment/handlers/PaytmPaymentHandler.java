package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.Paytm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaytmPaymentHandler implements IPaymentHandler{
    @Autowired
    private Paytm paytm;
    private final PaymentMethod paymentMethod = PaymentMethod.PAYTM;
    public PaytmPaymentHandler() {
        this.paytm = new Paytm();
    }

    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("PaytmPaymentHandler pay called");
        return this.paytm.pay(paytmNumber, amount);
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

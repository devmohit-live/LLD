package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.Paytm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaytmPaymentHandler implements IPaymentHandler{
    Paytm paytm;

    public PaytmPaymentHandler() {
        this.paytm = new Paytm();
    }

    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("PaytmPaymentHandler pay called");
        return this.paytm.pay(paytmNumber, amount);
    }
}

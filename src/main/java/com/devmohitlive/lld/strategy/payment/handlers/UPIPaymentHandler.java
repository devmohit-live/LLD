package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.UPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UPIPaymentHandler implements IPaymentHandler{
    private UPI upi;

    public UPIPaymentHandler() {
        System.out.println("UPIPaymentHandler constructor called");
        this.upi = new UPI();
    }

    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        return upi.pay(upiAddress, amount);
    }
}

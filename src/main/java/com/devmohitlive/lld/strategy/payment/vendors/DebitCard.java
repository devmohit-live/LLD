package com.devmohitlive.lld.strategy.payment.vendors;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;

public class DebitCard {
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, double amount){
        // Payment logic
        return PaymentStatus.COMPLETED;
    }
}

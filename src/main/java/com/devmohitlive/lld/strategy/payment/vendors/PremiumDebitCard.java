package com.devmohitlive.lld.strategy.payment.vendors;

import com.devmohitlive.lld.strategy.payment.dto.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class PremiumDebitCard {
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, double amount){
        // Payment logic
        return PaymentStatus.COMPLETED;
    }
}

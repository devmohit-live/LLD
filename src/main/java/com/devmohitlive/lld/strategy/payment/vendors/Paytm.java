package com.devmohitlive.lld.strategy.payment.vendors;

import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class Paytm {
    public PaymentStatus pay(String mobileNumber, double amount){
        // Payment logic
        return PaymentStatus.COMPLETED;
    }
}

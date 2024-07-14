package com.devmohitlive.lld.strategy.payment.vendors;

import com.devmohitlive.lld.strategy.payment.dto.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class UPI {
    public PaymentStatus pay(String upiAddress, double amount){
        // Payment logic
        return PaymentStatus.COMPLETED;
    }
}

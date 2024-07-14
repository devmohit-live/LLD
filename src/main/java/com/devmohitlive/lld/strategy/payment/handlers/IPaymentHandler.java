package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public interface IPaymentHandler {
    PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount);
}

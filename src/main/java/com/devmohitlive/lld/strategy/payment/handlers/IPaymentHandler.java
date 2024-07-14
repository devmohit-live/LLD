package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.dto.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.dto.IPaymentRequest;
import org.springframework.stereotype.Component;

@Component
public interface IPaymentHandler {
    PaymentStatus pay(IPaymentRequest paymentRequest, double amount);
    boolean isValidPaymentMethod(PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethod();

}

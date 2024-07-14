package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.dto.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.dto.IPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.User;
import org.springframework.stereotype.Component;

@Component
public interface IPaymentHandler {
    PaymentStatus pay(IPaymentRequest paymentRequest, double amount);
    boolean isValidPaymentMethod(User user, PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethod();

}

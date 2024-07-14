package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.dto.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.dto.User;

public interface CardPaymentHandler extends IPaymentHandler{
    @Override
    boolean isValidPaymentMethod(User user, PaymentMethod paymentMethod);
}

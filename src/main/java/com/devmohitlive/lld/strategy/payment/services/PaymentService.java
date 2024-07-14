package com.devmohitlive.lld.strategy.payment.services;


import com.devmohitlive.lld.strategy.payment.dto.IPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.dto.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.dto.User;
import com.devmohitlive.lld.strategy.payment.handlers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService{
    @Autowired
    List<IPaymentHandler> paymentHandlers;

    public PaymentStatus pay(User user, PaymentMethod paymentMethod, IPaymentRequest paymentRequest, double amount){
       PaymentStatus status = null;
       for (IPaymentHandler paymentHandler : paymentHandlers) {
           if (paymentHandler.isValidPaymentMethod(user, paymentMethod)) {
               status = paymentHandler.pay(paymentRequest, amount);
               break;
           }
       }
        return status;
    }
}

package com.devmohitlive.lld.strategy.payment;


import com.devmohitlive.lld.strategy.payment.dto.IPaymentRequest;
import com.devmohitlive.lld.strategy.payment.handlers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService{
    @Autowired
    List<IPaymentHandler> paymentHandlers;

    public PaymentStatus pay(PaymentMethod paymentMethod, IPaymentRequest paymentRequest, double amount){
       PaymentStatus status = null;
       for (IPaymentHandler paymentHandler : paymentHandlers) {
           if (paymentHandler.isValidPaymentMethod(paymentMethod)) {
               status = paymentHandler.pay(paymentRequest, amount);
               break;
           }
       }
        return status;
    }
}

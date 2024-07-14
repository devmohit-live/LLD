package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.UPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UPIPaymentHandler implements IPaymentHandler{
    @Autowired
    private UPI upi;
    private final PaymentMethod paymentMethod = PaymentMethod.UPI;


    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("UPIPaymentHandler pay called");
        return this.upi.pay(upiAddress, amount);
    }
    @Override
    public boolean isValidPaymentMethod(PaymentMethod paymentMethod) {
        return getPaymentMethod() == paymentMethod;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
}

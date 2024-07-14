package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.dto.CreditCardPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.DebitCardPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.IPaymentRequest;
import com.devmohitlive.lld.strategy.payment.vendors.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebitCardPaymentHandler implements IPaymentHandler {
    @Autowired
    private DebitCard debitCard;
    private final PaymentMethod paymentMethod = PaymentMethod.DEBIT_CARD;



    @Override
    public PaymentStatus pay(IPaymentRequest paymentRequest, double amount) {
        DebitCardPaymentRequest debitCardPaymentRequest = (DebitCardPaymentRequest) paymentRequest;
        return this.pay(debitCardPaymentRequest, amount);
    }

    private PaymentStatus pay(CreditCardPaymentRequest paymentRequest, double amount){
        System.out.println("DebitCardPaymentHandler pay called");
        return this.debitCard.pay(paymentRequest.getCardNumber(), paymentRequest.getCvv(), paymentRequest.getExpiryDate(), amount);
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

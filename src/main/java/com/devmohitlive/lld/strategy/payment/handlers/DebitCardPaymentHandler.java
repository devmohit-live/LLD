package com.devmohitlive.lld.strategy.payment.handlers;

import com.devmohitlive.lld.strategy.payment.PaymentMethod;
import com.devmohitlive.lld.strategy.payment.PaymentStatus;
import com.devmohitlive.lld.strategy.payment.vendors.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DebitCardPaymentHandler implements IPaymentHandler {
    @Autowired
    private DebitCard debitCard;
    private final PaymentMethod paymentMethod = PaymentMethod.DEBIT_CARD;


    public DebitCardPaymentHandler() {
        this.debitCard = new DebitCard();
    }

    @Override
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) {
        System.out.println("DebitCardPaymentHandler pay called");
        return this.debitCard.pay(cardNumber, cvv, expiryDate, amount);
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

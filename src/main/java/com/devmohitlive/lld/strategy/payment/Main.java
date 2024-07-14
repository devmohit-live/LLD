package com.devmohitlive.lld.strategy.payment;

import com.devmohitlive.lld.strategy.payment.dto.CreditCardPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.PaytmPaymentRequest;
import com.devmohitlive.lld.strategy.payment.dto.UPIPaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private PaymentService payment;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PaymentStatus status;
        //card
        CreditCardPaymentRequest creditCardPaymentRequest = new CreditCardPaymentRequest("1234 5678 9012 3456", "mohit","123", "12/23");
        status = payment.pay(PaymentMethod.CREDIT_CARD,creditCardPaymentRequest,1000);
        System.out.println(status);
        //upi
        UPIPaymentRequest upiPaymentRequest = new UPIPaymentRequest("mohit@upi");
        status = payment.pay(PaymentMethod.UPI,upiPaymentRequest,1000);
        System.out.println(status);
        // paytm
        PaytmPaymentRequest paytmPaymentRequest = new PaytmPaymentRequest("9999999999");
        status = payment.pay(PaymentMethod.PAYTM,paytmPaymentRequest,1000);
        System.out.println(status);
    }
}
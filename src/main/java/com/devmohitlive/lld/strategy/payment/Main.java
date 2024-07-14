package com.devmohitlive.lld.strategy.payment;

import com.devmohitlive.lld.strategy.payment.dto.*;
import com.devmohitlive.lld.strategy.payment.services.PaymentService;
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

        User normalUser = new User("mohit", Quota.NORMAL, "9999999999", "abc@mormal.com");
        User premiumUser = new User("mohit", Quota.PREMIUM, "9999999999", "abc@mormal.com");

        //card
        CreditCardPaymentRequest creditCardPaymentRequest = new CreditCardPaymentRequest("1234 5678 9012 3456", "mohit","123", "12/23");
        status = payment.pay(normalUser, PaymentMethod.CREDIT_CARD,creditCardPaymentRequest,1000);
        System.out.println(status);

        //card : premium
        creditCardPaymentRequest = new CreditCardPaymentRequest("1234 5678 9012 3456", "mohit","123", "12/23");
        status = payment.pay(premiumUser, PaymentMethod.CREDIT_CARD,creditCardPaymentRequest,1000);
        System.out.println(status);

        //upi
        UPIPaymentRequest upiPaymentRequest = new UPIPaymentRequest("mohit@upi");
        status = payment.pay(normalUser, PaymentMethod.UPI,upiPaymentRequest,1000);
        System.out.println(status);

        //upi premium user
         upiPaymentRequest = new UPIPaymentRequest("mohit@upi");
        status = payment.pay(premiumUser, PaymentMethod.UPI,upiPaymentRequest,1000);
        System.out.println(status);

        // paytm
        PaytmPaymentRequest paytmPaymentRequest = new PaytmPaymentRequest("9999999999");
        status = payment.pay(normalUser,PaymentMethod.PAYTM,paytmPaymentRequest,1000);
        System.out.println(status);
    }
}
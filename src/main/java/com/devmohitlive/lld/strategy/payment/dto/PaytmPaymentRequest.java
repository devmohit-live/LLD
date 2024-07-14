package com.devmohitlive.lld.strategy.payment.dto;

public class PaytmPaymentRequest implements IPaymentRequest{
    private String paytmMobileNumber;

    public PaytmPaymentRequest(String paytmMobileNumber) {
        this.paytmMobileNumber = paytmMobileNumber;
    }

    public String getPaytmMobileNumber() {
        return paytmMobileNumber;
    }
}

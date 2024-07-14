package com.devmohitlive.lld.strategy.payment.dto;

import org.springframework.stereotype.Component;

public class User {
    private String name;
    private Quota quota;
    private String number;
    private String email;

    public User(String name, Quota quota, String number, String email) {
        this.name = name;
        this.quota = quota;
        this.number = number;
        this.email = email;
    }

    public Quota getQuota() {
        return quota;
    }
}

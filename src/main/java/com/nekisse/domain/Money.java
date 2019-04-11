package com.nekisse.domain;

public class Money {

    private final int money;

    public Money(int inputAmount) {
        if (inputAmount < 1000 || inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위입니다.");
        }
            this.money = inputAmount;
    }

}

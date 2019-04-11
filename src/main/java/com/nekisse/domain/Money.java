package com.nekisse.domain;

public class Money {

    public static final int LOTTO_PRICE = 1000;
    private final int money;


    public Money(int inputAmount) {
        if (inputAmount < LOTTO_PRICE || inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위입니다.");
        }
            this.money = inputAmount;
    }

    public int buyLottoCount() {
        return money / LOTTO_PRICE;
    }

}

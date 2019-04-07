package com.kwonmc.lotto;

import java.util.ArrayList;

public class GameBuilder {
    private int purchaseAmount;
    private ArrayList<Lotto> myLottoList;
    private Lotto lastWeekNumbers;
    private int bonusNo;

    public GameBuilder setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        return this;
    }

    public GameBuilder setMyLottoList() {
        this.myLottoList = new ArrayList<>();
        // TODO 구매 금액만큼 로또 객체 생성하여 추가
        return this;
    }

    public GameBuilder setLastWeekNumbers(Lotto lastWeekNumbers) {
        this.lastWeekNumbers = lastWeekNumbers;
        return this;
    }
}
package com.kwonmc.lotto;

import java.util.ArrayList;

public class Game {
    private int purchaseAmount; // 구매금액
    private ArrayList<Lotto> myLottoList; // 구매한 로또 번호들
    private Lotto lastWeekNumbers; // 지난 주 당첨 번호
    private int bonusNo; // 보너스 볼 번호


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
    }
}

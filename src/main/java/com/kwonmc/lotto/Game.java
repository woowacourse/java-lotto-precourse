package com.kwonmc.lotto;

import java.util.ArrayList;

public class Game {
    private int purchaseAmount; // 구매금액
    private ArrayList<Lotto> myLottoList; // 구매한 로또 번호들
    private Lotto lastWeekNumbers; // 지난 주 당첨 번호
    private int bonusNo; // 보너스 볼 번호

    public void getPurchaseAmount(int purchaseAmount) {
        System.out.println(Constant.MESSAGE_GET_PURCHASE_AMOUNT);
        this.purchaseAmount = purchaseAmount;
    }
}

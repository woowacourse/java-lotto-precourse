package com.kwonmc.lotto;

import java.util.ArrayList;

public class Game {
    private int purchaseAmount; // 구매금액
    private ArrayList<Lotto> myLottoList; // 구매한 로또 번호들
    private Lotto lastWeekNumbers; // 지난 주 당첨 번호
    private int bonusNo; // 보너스 볼 번호

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setMyLottoList(ArrayList<Lotto> myLottoList) {
        this.myLottoList = myLottoList;
    }

    public ArrayList<Lotto> getMyLottoList() {
        return myLottoList;
    }

    public void setLastWeekNumbers(Lotto lastWeekNumbers) {
        this.lastWeekNumbers = lastWeekNumbers;
    }

    public void setBonusNo(int bonusNo) {
        this.bonusNo = bonusNo;
    }
}
